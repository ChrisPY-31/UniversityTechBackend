package com.example.nexustechuniversity.service;

import com.example.nexustechuniversity.Dto.CourseDto;
import com.example.nexustechuniversity.mapper.CourseMapper;
import com.example.nexustechuniversity.repository.CursoRepository;
import com.example.nexustechuniversity.service.Impl.ICourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CourseService implements ICourseService {

    private final CursoRepository cursoRepository;

    public CourseService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Page<CourseDto> getPaginatedCursos(int pageNumber, int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize, Sort.by("idCourse").descending());
        return cursoRepository.findAll(page).map(CourseMapper.INSTANCE::toCursoDto);
    }

    @Override
    public CourseDto getCursoById(long idCurso) {
        return cursoRepository.findById(idCurso)
                .map(CourseMapper.INSTANCE::toCursoDto)
                .orElseThrow(() -> new NoSuchElementException("Curso no encontrado: " + idCurso));
    }

    @Override
    public CourseDto createCurso(CourseDto curso) {
        return CourseMapper.INSTANCE.toCursoDto(cursoRepository.save(CourseMapper.INSTANCE.toCurso(curso)));
    }

    @Override
    public CourseDto updateCurso(CourseDto curso) {
        cursoRepository.findById(curso.getIdCurso())
                .orElseThrow(() -> new NoSuchElementException("Curso no encontrado: " + curso.getIdCurso()));
        return CourseMapper.INSTANCE.toCursoDto(cursoRepository.save(CourseMapper.INSTANCE.toCurso(curso)));
    }

    @Override
    public void deleteCurso(long idCurso) {
        cursoRepository.deleteById(idCurso);
    }
}
