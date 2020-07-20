package com.shamil.cloudlab2.service;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;

public interface FileService {
    File get(String fileName);
    String save(MultipartFile file);
    String getFileName(String fileName);
}