package kz.bitlab.streamlab.mapper.videos;

import kz.bitlab.streamlab.dto.videos.VideoThumbnailsDTO;
import kz.bitlab.streamlab.entities.impls.VideoThumbnails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {VideoStatisticsMapper.class, VideoStatisticsMapper.class,
        VideoThumbnailMapper.class, VideoThumbnailsMapper.class})
public interface VideoThumbnailsMapper {
    VideoThumbnailsMapper INSTANCE = Mappers.getMapper(VideoThumbnailsMapper.class);
    VideoThumbnailsDTO toVideoThumbnailsDto(VideoThumbnails videoThumbnails);
    VideoThumbnails toVideoThumbnailsEntity(VideoThumbnailsDTO videoThumbnailsDTO);
}
