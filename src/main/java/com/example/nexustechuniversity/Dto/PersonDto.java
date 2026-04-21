package com.example.nexustechuniversity.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDto {

    private long idPerson;

    private String name;

    private String lastname;

    private String phone;

    private String image;
}
