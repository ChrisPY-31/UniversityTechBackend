package com.example.nexustechuniversity.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LessonDto {

    private long idLesson;

    private long idCourse;

    @NotBlank
    private String title;

    private String description;

    private List<VideoDto> videos;

}
