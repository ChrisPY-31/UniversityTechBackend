package com.example.nexustechuniversity.Dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoDto {
    private long idVideo;

    private long idLesson;

    private String title;

    private String description;

    private String urlVideo;

    private int durationSeg;

    private boolean published;

    private LocalDate createAt = LocalDate.now();


}
