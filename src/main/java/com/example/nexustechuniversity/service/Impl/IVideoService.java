package com.example.nexustechuniversity.service.Impl;

import com.example.nexustechuniversity.Dto.VideoDto;

import java.util.List;
import java.util.Optional;

public interface IVideoService {

    List<VideoDto> getVideosByLesson(long idLesson);

    Optional<VideoDto> getVideoById(long idVideo);

    List<VideoDto> createVideo(List<VideoDto> video);

    VideoDto updateVideo(VideoDto video);

    void deleteVideo(long idVideo);
}
