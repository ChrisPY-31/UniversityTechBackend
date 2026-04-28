package com.example.nexustechuniversity.mapper;

import com.example.nexustechuniversity.Dto.CourseDto;
import com.example.nexustechuniversity.Model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    @Mapping(source = "idCurso", target = "idCourse")
    Course toCurso(CourseDto cursoDto);

    @Mapping(source = "idCourse", target = "idCurso")
    CourseDto toCursoDto(Course curso);

}
