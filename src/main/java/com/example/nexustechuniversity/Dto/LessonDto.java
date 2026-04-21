package com.example.nexustechuniversity.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LessonDto {

    private long idlesson;

    private String title;

    private String description;

    private String summary;

    private int order;

}
