package kz.bitlab.streamlab.mapper.videos;

import kz.bitlab.streamlab.dto.videos.VideoDTO;
import kz.bitlab.streamlab.entities.impls.Video;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring", uses = {VideoStatisticsMapper.class, VideoStatisticsMapper.class,
        VideoThumbnailMapper.class, VideoThumbnailsMapper.class})
public interface VideoMapper {
    VideoMapper INSTANCE = Mappers.getMapper(VideoMapper.class);


    @Mapping(source = "videoSnippet", target = "videoSnippetDTO")
    @Mapping(source = "videoStatistics", target = "videoStatisticsDTO")
    @Mapping(source = "videoThumbnails", target = "videoThumbnailsDTO")
    VideoDTO toVideoDto(Video video);

    @Mapping(source = "videoSnippetDTO", target = "videoSnippet")
    @Mapping(source = "videoStatisticsDTO", target = "videoStatistics")
    @Mapping(source = "videoThumbnailsDTO", target = "videoThumbnails")
    Video toVideoEntity(VideoDTO videoDTO);

    List<VideoDTO> toVideoDTOList(List<Video> videoList);
    List<Video> toVideoEntityList(List<VideoDTO> videoDTOList);
}
