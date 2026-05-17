package com.example.nexustechuniversity.controller;

import com.example.nexustechuniversity.Dto.VideoDto;
import com.example.nexustechuniversity.service.Impl.IFileUploadService;
import com.example.nexustechuniversity.service.Impl.IVideoService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class VideoController {

    private final IVideoService videoService;
    private final IFileUploadService fileUploadService;

    public VideoController(IVideoService videoService, IFileUploadService fileUploadService) {
        this.videoService = videoService;
        this.fileUploadService = fileUploadService;
    }

    @PreAuthorize("hasRole('INSTRUCTOR')")
    @GetMapping("lessons/{idLesson}/videos")
    public ResponseEntity<?> getVideosByLesson(@PathVariable long idLesson) {
        return ResponseEntity.ok(videoService.getVideosByLesson(idLesson));
    }

    @PreAuthorize("hasRole('INSTRUCTOR')")
    @GetMapping("videos/{id}")
    public ResponseEntity<?> getVideoById(@PathVariable long id) {
        return videoService.getVideoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('INSTRUCTOR')")
    @PostMapping("lessons/{idLesson}/videos")
    public ResponseEntity<?> createVideo(@PathVariable long idLesson, @RequestBody List<VideoDto> videoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(videoService.createVideo(videoDto));
    }

    @PreAuthorize("hasRole('INSTRUCTOR')")
    @PutMapping("videos/{id}")
    public ResponseEntity<?> updateVideo(@PathVariable long id, @RequestBody VideoDto videoDto) {
        videoDto.setIdVideo(id);
        return ResponseEntity.ok(videoService.updateVideo(videoDto));
    }

    @PreAuthorize("hasRole('INSTRUCTOR')")
    @DeleteMapping("videos/{id}")
    public ResponseEntity<?> deleteVideo(@PathVariable long id) {
        videoService.deleteVideo(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('INSTRUCTOR')")
    @PatchMapping("videos/{id}/upload")
    public ResponseEntity<?> uploadVideo(@PathVariable long id, @RequestParam("video")MultipartFile file) {
        fileUploadService.uploadVideo(id, file);
        return ResponseEntity.ok("Video subido con exito");
    }

}
