package com.example.nexustechuniversity.service.Impl;

import com.example.nexustechuniversity.Dto.CursoDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface ICursoService {

    Page<CursoDto> getPaginatedCursos(int pageNumber , int pageSize);

    CursoDto createCurso(CursoDto curso);

    void updateCurso(CursoDto curso);

    void deleteCurso(long idCurso);

}
