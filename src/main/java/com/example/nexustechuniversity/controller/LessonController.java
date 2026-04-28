package com.example.nexustechuniversity.controller;

import com.example.nexustechuniversity.Dto.LessonDto;
import com.example.nexustechuniversity.service.Impl.ILessonService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class LessonController {

    private final ILessonService lessonService;

    public LessonController(ILessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("lessons")
    public ResponseEntity<Page<LessonDto>> getLessons(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(lessonService.getPaginatedLessons(pageNumber, pageSize));
    }

    @GetMapping("cursos/{cursoId}/lessons")
    public ResponseEntity<List<LessonDto>> getLessonsByCurso(@PathVariable long cursoId) {
        return ResponseEntity.ok(lessonService.getLessonsByCurso(cursoId));
    }

    @GetMapping("lessons/{id}")
    public ResponseEntity<LessonDto> getLessonById(@PathVariable long id) {
        return lessonService.getLessonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("lessons")
    public ResponseEntity<List<LessonDto>> saveLesson(@RequestBody List<LessonDto> lesson) {
        return ResponseEntity.status(HttpStatus.CREATED).body(lessonService.createLesson(lesson));
    }

    @PutMapping("lessons/{id}")
    public ResponseEntity<LessonDto> updateLesson(@PathVariable long id, @RequestBody LessonDto lesson) {
        lesson.setIdLesson(id);
        return ResponseEntity.ok(lessonService.updateLesson(lesson));
    }

    @DeleteMapping("lessons/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable long id) {
        lessonService.deleteLesson(id);
        return ResponseEntity.noContent().build();
    }

}
