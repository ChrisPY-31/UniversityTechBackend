package com.example.nexustechuniversity.service.Impl;

import com.example.nexustechuniversity.Dto.LessonDto;

import java.util.List;

public interface ILessonService {

    List<LessonDto> getLessons(LessonDto lesson);

    LessonDto createLesson(LessonDto lesson);

    LessonDto updateLesson(LessonDto lesson);

    void delete(long idLesson);

}
