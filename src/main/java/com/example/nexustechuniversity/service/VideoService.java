package com.example.nexustechuniversity.service;

import com.example.nexustechuniversity.Dto.VideoDto;
import com.example.nexustechuniversity.service.Impl.IVideoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService implements IVideoService {

    @Override
    public List<VideoDto> getVideos() {
        return List.of();
    }

    @Override
    public List<VideoDto> createVideos(List<VideoDto> videos) {
        return List.of();
    }

    @Override
    public VideoDto updateVideo(VideoDto videos) {
        return null;
    }

    @Override
    public void deleteVideo(VideoDto video) {

    }
}
