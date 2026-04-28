package com.example.nexustechuniversity.service;

import com.example.nexustechuniversity.Dto.CourseDto;
import com.example.nexustechuniversity.mapper.CursoMapper;
import com.example.nexustechuniversity.repository.CursoRepository;
import com.example.nexustechuniversity.service.Impl.ICursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class CursoService implements ICursoService {

	@Autowired
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Page<CourseDto> getPaginatedCursos(int pageNumber , int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize , Sort.by("idCurso").descending());
        return cursoRepository.findAll(page).map(CursoMapper.INSTANCE::toCursoDto);
    }

    @Override
    public CourseDto createCurso(CourseDto curso) {
        return CursoMapper.INSTANCE.toCursoDto(cursoRepository.save(CursoMapper.INSTANCE.toCurso(curso)));
    }

    @Override
    public void updateCurso(CourseDto curso) {

    }

    @Override
    public void deleteCurso(long idCurso) {

    }
}
