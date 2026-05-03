package com.example.nexustechuniversity.service.Impl;

import com.example.nexustechuniversity.Dto.LessonDto;

import java.util.List;
import java.util.Optional;

public interface ILessonService {

    List<LessonDto> getLessonsByCurso(long idCourse);

    Optional<LessonDto> getLessonById(long idLesson);

    List<LessonDto> createLesson(List<LessonDto> lesson);

    LessonDto updateLesson(LessonDto lesson);

    void deleteLesson(long idLesson);

}
