package com.shamil.cloudlab2.service;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.models.ListBlobsOptions;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FileServiceImpl implements FileService {

    private BlobContainerClient container;
    private ListBlobsOptions options;
    private String STORAGE_PATH = System.getProperty("user.home") + "\\Downloads\\";

    public FileServiceImpl(BlobServiceClient blobServiceClient, ListBlobsOptions options) {
        this.options = options;
        this.container = blobServiceClient.getBlobContainerClient("cloudlab-storage");
    }

    @Override
    public File get(String fileName) {

        var originalFileName = getOriginName(fileName);

        var path = STORAGE_PATH + originalFileName;
        File file = new File(path);
        if (file.exists()) {
            file.renameTo(new File(path.replace(path, STORAGE_PATH
                    + "(" + UUID.randomUUID().toString().substring(35)) + ")" + originalFileName));
        }
        container.getBlobClient(fileName).downloadToFile(path);
        container.getBlobClient(fileName).delete();
        return file;
    }

    @Override
    public String save(MultipartFile file) {
        try {
            var fileName = UUID.randomUUID().toString();
            var blobClient = container.getBlobClient(fileName);

            var path = STORAGE_PATH + fileName;
            var targetFile = new File(path);
            Map<String, String> originMap = new HashMap<>();

            originMap.put("originalName", Objects.requireNonNull(file.getOriginalFilename()).replaceAll(" ", ""));
            FileUtils.copyInputStreamToFile(file.getInputStream(), targetFile);

            blobClient.uploadFromFile(path);
            blobClient.setMetadata(originMap);

            targetFile.delete();
            return fileName;
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
    }

    @Override
    public String getOriginName(String fileName) {
        var names = container.listBlobs(options, null)
                .stream()
                .filter(blob -> blob.getName().equals(fileName))
                .map(b -> b.getMetadata().get("originalName"))
                .collect(Collectors.toList());

        if (names.size() == 0) {
            throw new IllegalArgumentException("Incorrect file name, or file was removed");
        }

        return names.get(0);
    }
}