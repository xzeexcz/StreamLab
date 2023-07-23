package kz.bitlab.streamlab.mapper.videos;

import kz.bitlab.streamlab.dto.videos.VideoStatisticsDTO;
import kz.bitlab.streamlab.entities.impls.VideoStatistics;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {VideoStatisticsMapper.class, VideoStatisticsMapper.class,
        VideoThumbnailMapper.class, VideoThumbnailsMapper.class})
public interface VideoStatisticsMapper {
    VideoStatisticsMapper INSTANCE = Mappers.getMapper(VideoStatisticsMapper.class);

    VideoStatisticsDTO toVideoStatisticsDto(VideoStatistics videoStatistics);
    VideoStatistics toVideoStatisticsEntity(VideoStatisticsDTO videoStatisticsDTO);
}
