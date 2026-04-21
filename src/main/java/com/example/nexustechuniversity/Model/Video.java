package com.example.nexustechuniversity.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "video")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVideo;

    private long idLesson;

    private String title;

    private String urlVideo;

    private int durationSeg;

    private int order;

    private boolean publicate;

    private LocalDate create;

    @ManyToOne
    @JoinColumn(name = "idLesson" , referencedColumnName = "idLesson" , insertable = false, updatable = false)
    private Lesson lesson;


}
