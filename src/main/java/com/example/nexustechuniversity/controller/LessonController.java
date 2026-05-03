package com.example.nexustechuniversity.controller;

import com.example.nexustechuniversity.Dto.LessonDto;
import com.example.nexustechuniversity.service.Impl.ILessonService;
import jakarta.validation.Valid;
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

    //ruta esta bien
    @GetMapping("cursos/{cursoId}/lessons")
    public ResponseEntity<List<LessonDto>> getLessonsByCurso(@PathVariable long cursoId) {
        List<LessonDto> lessons = lessonService.getLessonsByCurso(cursoId);
        if(!lessons.isEmpty()){
            return ResponseEntity.ok(lessons);
        }
        return new ResponseEntity<>(lessons,HttpStatus.NOT_FOUND);
    }

    @GetMapping("lessons/{id}")
    public ResponseEntity<LessonDto> getLessonById(@PathVariable long id) {
        return lessonService.getLessonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //esta ruta concluida
    @PostMapping("lessons")
    public ResponseEntity<List<LessonDto>> saveLesson(@RequestBody @Valid List<LessonDto> lesson) {
        return ResponseEntity.status(HttpStatus.CREATED).body(lessonService.createLesson(lesson));
    }

    //esta igual ya se puede 
    @PutMapping("lessons/{id}")
    public ResponseEntity<LessonDto> updateLesson(@PathVariable long id, @RequestBody @Valid LessonDto lesson) {
        lesson.setIdLesson(id);
        return ResponseEntity.ok(lessonService.updateLesson(lesson));
    }

    @DeleteMapping("lessons/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable long id) {
        lessonService.deleteLesson(id);
        return ResponseEntity.noContent().build();
    }

}
