package com.example.nexustechuniversity.mapper;

import com.example.nexustechuniversity.Dto.CursoDto;
import com.example.nexustechuniversity.Model.Curso;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CursoMapper {

    CursoMapper INSTANCE = Mappers.getMapper(CursoMapper.class);

    Curso toCurso(CursoDto cursoDto);

    CursoDto toCursoDto(Curso curso);


}
