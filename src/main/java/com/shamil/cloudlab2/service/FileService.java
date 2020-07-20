package com.shamil.cloudlab2.service;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;

public interface FileService {
    String save(MultipartFile file);
    File get(String fileName);
    String getFileName(String fileName);
}