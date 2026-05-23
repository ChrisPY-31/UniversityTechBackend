package com.example.nexustechuniversity.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDto {

    private long id;

    private String title;

    private String description;

    private String category;

    private String nevel;

    private String image;

    private String published;

    private Long instructorId;

    private String instructorName;

}
