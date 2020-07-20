package com.shamil.cloudlab2.controllers;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.shamil.cloudlab2.service.FileService;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/upload")
    public String getPage() {
        return "uploadPage";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile, ModelMap modelMap) {
        var downloadLink = "download/page/" + fileService.save(multipartFile);
        modelMap.addAttribute("link", downloadLink);
        return "downloadLinkPage";
    }

    @GetMapping("/download/{file_name}")
    public void getFile(@PathVariable("file_name") String fileName, HttpServletResponse response) {
        try {
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileService.getFileName(fileName) + "\"");
            InputStream inputStream = new FileInputStream(fileService.get(fileName));
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/download/page/{file_name}")
    public String getFilePage(ModelMap map, @PathVariable("file_name") String fileName) {
        map.addAttribute("fileName", fileService.getFileName(fileName));
        map.addAttribute("link", fileName);
        return "downloadFilePage";
    }
}