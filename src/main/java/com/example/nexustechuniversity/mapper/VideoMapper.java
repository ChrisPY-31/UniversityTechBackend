package com.example.nexustechuniversity.mapper;

import com.example.nexustechuniversity.Dto.VideoDto;
import com.example.nexustechuniversity.Model.Video;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VideoMapper {

    VideoMapper INSTANCE = Mappers.getMapper(VideoMapper.class);

    Video toVideo(VideoDto videoDto);

    VideoDto toVideoDto(Video video);

    List<VideoDto> toListVideoDto(List<Video> videos);

    List<Video> toListVideo(List<VideoDto> videoDtos);
}
