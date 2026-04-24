package com.example.nexustechuniversity.service.Impl;

import com.example.nexustechuniversity.Dto.CursoDto;
import org.springframework.data.domain.Page;

public interface ICursoService {

    Page<CursoDto> getPaginatedCursos(int pageNumber , int pageSize);

    CursoDto createCurso(CursoDto curso);

    void updateCurso(CursoDto curso);

    void deleteCurso(long idCurso);

}
