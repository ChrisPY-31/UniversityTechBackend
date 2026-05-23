package com.example.nexustechuniversity.mapper;

import com.example.nexustechuniversity.Dto.CourseResponseDto;
import com.example.nexustechuniversity.Model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseResponseMapper {

    CourseResponseMapper INSTANCE = Mappers.getMapper(CourseResponseMapper.class);

    @Mapping(source = "idCourse", target = "id")
    @Mapping(source = "instructor.idPerson", target = "instructorId")
    @Mapping(expression = "java(course.getInstructor() != null ? course.getInstructor().getName() + \" \" + course.getInstructor().getLastName() : null)", target = "instructorName")
    CourseResponseDto toCourseResponseDto(Course course);

}
