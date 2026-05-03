package com.example.nexustechuniversity.Dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDto {

    private long idCourse;

    private String title;

    private String description;

    private String category;

    private String nevel;

    private String image;

    private LocalDate create;

    private List<LessonDto> lessonsDto;
}
