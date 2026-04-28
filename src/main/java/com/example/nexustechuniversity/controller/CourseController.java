package com.example.nexustechuniversity.controller;

import com.example.nexustechuniversity.Dto.CourseDto;
import com.example.nexustechuniversity.service.Impl.ICourseService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class CourseController {

    private final ICourseService cursoService;

    public CourseController(ICourseService cursoService) {
        this.cursoService = cursoService;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("cursos")
    public ResponseEntity<Page<CourseDto>> getCursos(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(cursoService.getPaginatedCursos(pageNumber, pageSize));
    }

    @GetMapping("cursos/{id}")
    public ResponseEntity<CourseDto> getCursoById(@PathVariable long id) {
        CourseDto course = cursoService.getCursoById(id);
        return new ResponseEntity<>(course , HttpStatus.OK);
    }

    @PreAuthorize("hasRole('INSTRUCTOR')")
    @PostMapping("cursos")
    public ResponseEntity<CourseDto> saveCurso(@RequestBody CourseDto curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.createCurso(curso));
    }

    @PreAuthorize("hasRole('INSTRUCTOR')")
    @PutMapping("cursos/{id}")
    public ResponseEntity<CourseDto> updateCurso(@PathVariable long id, @RequestBody CourseDto updateCurso) {
        updateCurso.setIdCurso(id);
        return ResponseEntity.ok(cursoService.updateCurso(updateCurso));
    }

    @PreAuthorize("hasRole('INSTRUCTOR')")
    @DeleteMapping("cursos/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable long id) {
        cursoService.deleteCurso(id);
        return ResponseEntity.noContent().build();
    }

}
