package com.example.nexustechuniversity.service.Impl;

import org.springframework.web.multipart.MultipartFile;

public interface IFileUploadService {

    void uploadImageCourse(long id , MultipartFile file);

    void uploadImagePerson(long id , MultipartFile file);

}
