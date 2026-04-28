package com.example.nexustechuniversity.service.Impl;

import com.example.nexustechuniversity.Dto.LessonDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ILessonService {

    Page<LessonDto> getPaginatedLessons(int pageNumber, int pageSize);

    List<LessonDto> getLessonsByCurso(long idCurso);

    Optional<LessonDto> getLessonById(long idLesson);

    List<LessonDto> createLesson(List<LessonDto> lesson);

    LessonDto updateLesson(LessonDto lesson);

    void deleteLesson(long idLesson);

}
