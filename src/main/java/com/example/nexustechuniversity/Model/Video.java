package com.example.nexustechuniversity.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "videos")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_video")
    private long idVideo;

    @Column(name = "id_lesson")
    private long idLesson;

    private String title;

    @Column(name = "url_video")
    private String urlVideo;

    @Column(name = "duration_seg")
    private int durationSeg;

    private boolean publicate;

    @Column(name = "create_at")
    private LocalDate createAt;

    @ManyToOne
    @JoinColumn(name = "id_lesson" , referencedColumnName = "id_lesson" , insertable = false, updatable = false)
    private Lesson lesson;


}
