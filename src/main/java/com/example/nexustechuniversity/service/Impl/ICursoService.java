package com.example.nexustechuniversity.service.Impl;

import com.example.nexustechuniversity.Dto.CourseDto;
import com.example.nexustechuniversity.Dto.CursoDto;
import org.springframework.data.domain.Page;

public interface ICursoService {

    Page<CourseDto> getPaginatedCursos(int pageNumber , int pageSize);

    CourseDto createCurso(CourseDto curso);

    void updateCurso(CourseDto curso);

    void deleteCurso(long idCurso);

}
