package com.example.nexustechuniversity.repository;

import com.example.nexustechuniversity.Model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso , Long> {


}
