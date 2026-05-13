package com.example.nexustechuniversity.service.Impl;

import com.example.nexustechuniversity.Dto.CourseDto;
import com.example.nexustechuniversity.Dto.CourseResponseDto;
import org.springframework.data.domain.Page;


public interface ICourseService {

    Page<CourseResponseDto> getPaginatedCursos(int pageNumber, int pageSize);

    CourseDto getCursoById(long idCurso);

    CourseDto createCurso(CourseDto curso);

    CourseDto updateCurso(CourseDto curso);

    void deleteCurso(long idCurso);

}
