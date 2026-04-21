package com.example.nexustechuniversity.controller;

import com.example.nexustechuniversity.Dto.CursoDto;
import com.example.nexustechuniversity.service.Impl.ICursoService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class CursoController {

    private final ICursoService cursoService;

    public CursoController(ICursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("cursos")
    public ResponseEntity<Page<CursoDto>> getCursos(@RequestParam(defaultValue = "0") int pageNumber ,
                                                 @RequestParam(defaultValue = "10") int pageSize){
        Page<CursoDto> cursoPage = cursoService.getPaginatedCursos(pageNumber , pageSize);
        return ResponseEntity.ok(cursoPage);
    }

    @PostMapping("cursos")
    public ResponseEntity<?> saveCurso(){
        return ResponseEntity.ok("Creando curso");
    }

    @PutMapping("cursos")
    public ResponseEntity<?> updateCurso (){
        return ResponseEntity.ok("Actualizando curso");
    }

    @DeleteMapping("cursos")
    public ResponseEntity<?> deleteCurso(){
        return ResponseEntity.ok("Actualizando curso");

    }

}
