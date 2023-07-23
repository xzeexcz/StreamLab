package kz.bitlab.streamlab.mapper.videos;

import kz.bitlab.streamlab.dto.videos.VideoThumbnailDTO;
import kz.bitlab.streamlab.entities.impls.VideoThumbnail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {VideoStatisticsMapper.class, VideoStatisticsMapper.class,
        VideoThumbnailMapper.class, VideoThumbnailsMapper.class})
public interface VideoThumbnailMapper {
    VideoThumbnailMapper INSTANCE = Mappers.getMapper(VideoThumbnailMapper.class);

    VideoThumbnailDTO toVideoThumbnailDto(VideoThumbnail videoThumbnail);
    VideoThumbnail toVideoThumbnailEntity(VideoThumbnailDTO videoThumbnailDTO);
}
