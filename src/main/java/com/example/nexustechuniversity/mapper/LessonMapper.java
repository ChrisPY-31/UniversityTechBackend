package com.example.nexustechuniversity.mapper;

import com.example.nexustechuniversity.Dto.LessonDto;
import com.example.nexustechuniversity.Model.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LessonMapper {

    LessonMapper INSTANCE = Mappers.getMapper(LessonMapper.class);

    @Mapping(source = "idCurso", target = "idCourse")
    Lesson toLesson(LessonDto lessonDto);

    @Mapping(source = "idCourse", target = "idCurso")
    LessonDto toLessonDto(Lesson lesson);

    List<LessonDto> toListLessonDto(List<Lesson> lessons);

    List<Lesson> toListLesson(List<LessonDto> lessonDtos);

}
