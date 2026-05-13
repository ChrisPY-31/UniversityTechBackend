package com.example.nexustechuniversity.controller;

import com.example.nexustechuniversity.service.Impl.IFileUploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/")
public class FileUploadController {

    private final IFileUploadService fileUploadService;

    public FileUploadController(IFileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PreAuthorize("isAuthenticated()")
    @PatchMapping("users/{id}/image")
    public ResponseEntity<?> fileUpdateImage(@PathVariable Long id , @RequestParam("image")MultipartFile file){
        fileUploadService.uploadImagePerson(id , file);
        return ResponseEntity.ok("Imagen actualizada con exito");

    }

    @PreAuthorize("hasRole('INSTRUCTOR')")
    @PatchMapping("course/{id}/image")
    public ResponseEntity<?> fileUpdateCourseImage(@PathVariable Long id , @RequestParam("image")MultipartFile file){
        fileUploadService.uploadImageCourse(id , file);
        return ResponseEntity.ok("Imagen actualizada con exito");

    }
}
