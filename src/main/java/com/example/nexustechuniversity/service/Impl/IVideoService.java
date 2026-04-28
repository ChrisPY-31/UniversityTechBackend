package com.example.nexustechuniversity.service.Impl;

import com.example.nexustechuniversity.Dto.VideoDto;

import java.util.List;

public interface IVideoService {

    List<VideoDto> getVideos();

    List<VideoDto> createVideos(List<VideoDto> videos);

    VideoDto updateVideo(VideoDto videos);

    void deleteVideo(VideoDto video);
}
