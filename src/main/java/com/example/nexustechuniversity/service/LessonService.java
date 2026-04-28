package com.example.nexustechuniversity.service;

import com.example.nexustechuniversity.Dto.LessonDto;
import com.example.nexustechuniversity.mapper.LessonMapper;
import com.example.nexustechuniversity.repository.LessonRepository;
import com.example.nexustechuniversity.service.Impl.ILessonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service

public class LessonService implements ILessonService {

    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public Page<LessonDto> getPaginatedLessons(int pageNumber, int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize, Sort.by("idLesson").descending());
        return lessonRepository.findAll(page).map(LessonMapper.INSTANCE::toLessonDto);
    }

    @Override
    public List<LessonDto> getLessonsByCurso(long idCurso) {
        return lessonRepository.findByIdCourse(idCurso)
                .stream()
                .map(LessonMapper.INSTANCE::toLessonDto)
                .toList();
    }

    @Override
    public Optional<LessonDto> getLessonById(long idLesson) {
        return lessonRepository.findById(idLesson).map(LessonMapper.INSTANCE::toLessonDto);
    }

    @Override
    public List<LessonDto> createLesson(List<LessonDto> lessons) {
    return LessonMapper.INSTANCE.toListLessonDto(lessonRepository.saveAll(LessonMapper.INSTANCE.toListLesson(lessons)));
    }

    @Override
    public LessonDto updateLesson(LessonDto lesson) {
        lessonRepository.findById(lesson.getIdLesson())
                .orElseThrow(() -> new NoSuchElementException("Lesson no encontrada: " + lesson.getIdLesson()));
        return LessonMapper.INSTANCE.toLessonDto(lessonRepository.save(LessonMapper.INSTANCE.toLesson(lesson)));
    }

    @Override
    public void deleteLesson(long idLesson) {
        lessonRepository.deleteById(idLesson);
    }
}
