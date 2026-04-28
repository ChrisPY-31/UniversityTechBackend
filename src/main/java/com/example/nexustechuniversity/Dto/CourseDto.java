package com.example.nexustechuniversity.Dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDto {

    private long idCurso;

    private String title;

    private String description;

    private String category;

    private String nevel;

    private String image;

    private LocalDate create;

}
