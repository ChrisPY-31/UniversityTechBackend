package com.example.nexustechuniversity.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private long idCourse;

    private String title;

    private String description;

    private String category;

    private String nevel;

    private String image;

    @Column(name = "create_at")
    private LocalDate createAt;

    @OneToMany(mappedBy = "course")
    List<Lesson> lessons;
}
