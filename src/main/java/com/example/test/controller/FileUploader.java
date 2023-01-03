package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class FileUploader {
    @PostMapping
    public String handleFormUpload(@RequestParam("file") MultipartFile file,
                                   Model model) throws IOException {
        if (!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            String targetFilename = UUID.randomUUID() +
                    originalFilename.substring(originalFilename.lastIndexOf("."));
            file.transferTo(Paths.get("./upload/"+targetFilename));
            String message = String.format("上传成功：%s；文件大小：%d字节",
                    file.getOriginalFilename(),
                    file.getSize());
            model.addAttribute("message",message);
            model.addAttribute("targetFilename", targetFilename);
        }
        return "upload";
    }

    @GetMapping
    public String setUpUploadForm() {
        return "upload";
    }
}
