package com.example.nexustechuniversity.mapper;

import com.example.nexustechuniversity.Dto.CourseDto;
import com.example.nexustechuniversity.Model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CursoMapper {

    CursoMapper INSTANCE = Mappers.getMapper(CursoMapper.class);

    Course toCurso(CourseDto courseDto);

    CourseDto toCursoDto(Course course);


}
