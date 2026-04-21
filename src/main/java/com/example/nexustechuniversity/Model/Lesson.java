package com.example.nexustechuniversity.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "lesson")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLesson;

    private long idCurso;

    private String title;

    private String description;

    private String summary;

    private int order;

    private boolean publicate;

    @OneToMany(mappedBy = "lesson")
    private List<Video> videos;

    @ManyToOne
    @JoinColumn(name = "idCurso" , referencedColumnName = "idCurso" , insertable = false,updatable = false )
    private Curso curso;

}
