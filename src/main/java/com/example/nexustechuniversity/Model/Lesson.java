package com.example.nexustechuniversity.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "lessons")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lesson")
    private long idLesson;

    @Column(name = "id_course")
    private long idCourse;

    private String title;

    private String description;

    private String summary;

    private boolean publicate;

    @OneToMany(mappedBy = "lesson")
    private List<Video> videos;

    @ManyToOne
    @JoinColumn(name = "id_course" , referencedColumnName = "id_course" , insertable = false,updatable = false )
    private Course course;

}
