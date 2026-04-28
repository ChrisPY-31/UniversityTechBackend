package com.example.nexustechuniversity.controller;

import com.example.nexustechuniversity.service.Impl.IFileUploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/")
public class FileUploadController {

    private final IFileUploadService fileUploadService;

    public FileUploadController(IFileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PatchMapping("user/file/{id}")
    public ResponseEntity<?> fileUpdateImage(@PathVariable Long id , @RequestParam("image")MultipartFile file){
        fileUploadService.uploadImagePerson(id , file);
        return ResponseEntity.ok("nice");

    }

    @PatchMapping("course/file/{id}")
    public ResponseEntity<?> fileUpdateCourseImage(@PathVariable Long id , @RequestParam("image")MultipartFile file){
        fileUploadService.uploadImageCourse(id , file);
        return ResponseEntity.ok("nice");

    }
}
