package com.example.nexustechuniversity.repository;

import com.example.nexustechuniversity.Model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video , Long> {

    List<Video> findByIdLesson(long idLesson);
}
