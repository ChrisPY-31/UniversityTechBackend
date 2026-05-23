package com.example.nexustechuniversity.service;

import com.example.nexustechuniversity.Dto.VideoDto;
import com.example.nexustechuniversity.Model.Video;
import com.example.nexustechuniversity.mapper.VideoMapper;
import com.example.nexustechuniversity.repository.LessonRepository;
import com.example.nexustechuniversity.repository.VideoRepository;
import com.example.nexustechuniversity.service.Impl.IVideoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VideoService implements IVideoService {

    private final VideoRepository videoRepository;
    private final LessonRepository lessonRepository;

    public VideoService(VideoRepository videoRepository, LessonRepository lessonRepository) {
        this.videoRepository = videoRepository;
        this.lessonRepository = lessonRepository;
    }

    @Override
    public List<VideoDto> getVideosByLesson(long idLesson) {
        return VideoMapper.INSTANCE.toListVideoDto(videoRepository.findByIdLesson(idLesson));
    }

    @Override
    public Optional<VideoDto> getVideoById(long idVideo) {
        return videoRepository.findById(idVideo).map(VideoMapper.INSTANCE::toVideoDto);
    }

    @Override
    public List<VideoDto> createVideo(List<VideoDto> video) {
        /**
         *
        lessonRepository.findById(video.contains(video.))
                .orElseThrow(() -> new NoSuchElementException("Lesson no encontrada: " + video.getIdLesson()));
        video.setCreateAt(LocalDate.now());
         *
         */

        return VideoMapper.INSTANCE.toListVideoDto(videoRepository.saveAll(VideoMapper.INSTANCE.toListVideo(video)));
    }

    @Override
    public VideoDto updateVideo(VideoDto video) {
        Video existing = videoRepository.findById(video.getIdVideo())
                .orElseThrow(() -> new NoSuchElementException("Video no encontrado: " + video.getIdVideo()));
        Video updated = VideoMapper.INSTANCE.toVideo(video);
        updated.setIdLesson(existing.getIdLesson());
        return VideoMapper.INSTANCE.toVideoDto(videoRepository.save(updated));
    }

    @Override
    public void deleteVideo(long idVideo) {
        videoRepository.findById(idVideo)
                .orElseThrow(() -> new NoSuchElementException("Video no encontrado: " + idVideo));
        videoRepository.deleteById(idVideo);
    }
}
