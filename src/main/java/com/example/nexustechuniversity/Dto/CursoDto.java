package com.example.nexustechuniversity.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CursoDto {

    private long idCurso;

    private String title;

    private String description;

    private String category;

    private String nevel;

}
