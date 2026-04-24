package com.example.nexustechuniversity.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "curso")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCurso;

    private String title;

    private String description;

    private String category;

    private String nevel;

    private String image;

    @Column(name = "\"create\"")
    private LocalDate create;

    @OneToMany(mappedBy = "curso")
    List<Lesson> lessons;
}
