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

    private String urlVideo;

    private int durationSeg;

    private int order;

    private boolean publicate;

    private LocalDate create;
}
