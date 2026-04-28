package com.example.nexustechuniversity.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.nexustechuniversity.Dto.CourseDto;
import com.example.nexustechuniversity.Dto.PersonDto;
import com.example.nexustechuniversity.config.CloudinaryConfig;
import com.example.nexustechuniversity.service.Impl.ICourseService;
import com.example.nexustechuniversity.service.Impl.IFileUploadService;
import com.example.nexustechuniversity.service.Impl.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FileUploadService implements IFileUploadService {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private ICourseService courseService;

    @Autowired
    private IPersonService personService;


    @Override
    public void uploadImageCourse(long id, MultipartFile file) {

        List<String> allowedExtensions = Arrays.asList("jpg", "jpeg", "png", "webp", "avif");

        CourseDto courseFile = courseService.getCursoById(id) ;

        if (file == null || file.isEmpty()) {
            throw new RuntimeException("File is null or empty");
        }

        String extension = null;

        if (file.getOriginalFilename() != null) {
            String[] splitName = file.getOriginalFilename().split("\\.");
            if (splitName.length > 1) {
                extension = splitName[splitName.length - 1].toLowerCase();
            }
        }

        if (extension == null || !allowedExtensions.contains(extension)) {
            throw new RuntimeException(String.format("Extension %s not allowed. Allowed extensions: %s",
                    extension, allowedExtensions));
        }

        try {
            Map<String, Object> result = cloudinary.uploader().upload(
                    file.getBytes(),
                    ObjectUtils.asMap("folder", "Cursos")
            );

            String imageUserUrl = result.get("secure_url").toString();
            courseFile.setImage(imageUserUrl);


            courseService.updateCurso(courseFile);
            // Aquí deberías guardar la persona actualizada en la base de datos
            // personService.updatePerson(personaFile);


        } catch (Exception e) {
            throw new RuntimeException("Error uploading file: " + e.getMessage());
        }
    }

    @Override
    public void uploadImagePerson(long id, MultipartFile file) {

        List<String> allowedExtensions = Arrays.asList("jpg", "jpeg", "png", "webp", "avif");

        PersonDto personFile = personService.getPersonId(id);

        if (file == null || file.isEmpty()) {
            throw new RuntimeException("File is null or empty");
        }

        String extension = null;

        if (file.getOriginalFilename() != null) {
            String[] splitName = file.getOriginalFilename().split("\\.");
            if (splitName.length > 1) {
                extension = splitName[splitName.length - 1].toLowerCase();
            }
        }

        if (extension == null || !allowedExtensions.contains(extension)) {
            throw new RuntimeException(String.format("Extension %s not allowed. Allowed extensions: %s",
                    extension, allowedExtensions));
        }

        try {
            Map<String, Object> result = cloudinary.uploader().upload(
                    file.getBytes(),
                    ObjectUtils.asMap("folder", "Usuarios")
            );

            String imageUserUrl = result.get("secure_url").toString();
            personFile.setImage(imageUserUrl);


            personService.createPerson(personFile);
            // Aquí deberías guardar la persona actualizada en la base de datos
            // personService.updatePerson(personaFile);


        } catch (Exception e) {
            throw new RuntimeException("Error uploading file: " + e.getMessage());
        }
    }
}
