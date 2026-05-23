package com.example.nexustechuniversity.Dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDto {

    private long idPerson;

    private String name;

    private String lastName;

    private String phone;

    private String image;

    private List<CourseResponseDto> courses;
}
