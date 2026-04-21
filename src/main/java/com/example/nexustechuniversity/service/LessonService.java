package com.example.nexustechuniversity.service;

import com.example.nexustechuniversity.Dto.LessonDto;
import com.example.nexustechuniversity.service.Impl.ILessonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService implements ILessonService {
    @Override
    public List<LessonDto> getLessons(LessonDto lesson) {
        return List.of();
    }

    @Override
    public LessonDto createLesson(LessonDto lesson) {
        return null;
    }

    @Override
    public LessonDto updateLesson(LessonDto lesson) {
        return null;
    }

    @Override
    public void delete(long idLesson) {

    }
}
