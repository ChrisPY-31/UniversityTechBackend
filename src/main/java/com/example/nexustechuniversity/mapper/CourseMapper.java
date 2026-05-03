package com.example.nexustechuniversity.mapper;

import com.example.nexustechuniversity.Dto.CourseDto;
import com.example.nexustechuniversity.Model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    Course toCurso(CourseDto cursoDto);

    CourseDto toCursoDto(Course curso);

}
