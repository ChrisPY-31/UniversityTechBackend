package com.example.nexustechuniversity.repository;

import com.example.nexustechuniversity.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Course, Long> {


}
