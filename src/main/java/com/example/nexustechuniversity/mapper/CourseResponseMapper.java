package com.example.nexustechuniversity.mapper;

import com.example.nexustechuniversity.Dto.CourseDto;
import com.example.nexustechuniversity.Dto.CourseResponseDto;
import com.example.nexustechuniversity.Model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseResponseMapper {

    CourseResponseMapper INSTANCE = Mappers.getMapper(CourseResponseMapper.class);

    CourseResponseDto toCourseResponseDto(Course course);


}
