package com.example.nexustechuniversity.mapper;

import com.example.nexustechuniversity.Dto.LessonDto;
import com.example.nexustechuniversity.Model.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LessonMapper {

    LessonMapper INSTANCE = Mappers.getMapper(LessonMapper.class);

    Lesson toLesson(LessonDto lessonDto);

    LessonDto toLessonDto(Lesson lesson);

    List<LessonDto> toListLessonDto(List<Lesson> lessons);

    List<Lesson> toListLesson(List<LessonDto> lessonDtos);

}
