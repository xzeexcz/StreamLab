package kz.bitlab.streamlab.mapper.videos;

import kz.bitlab.streamlab.dto.videos.VideoSnippetDTO;
import kz.bitlab.streamlab.entities.impls.VideoSnippet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {VideoStatisticsMapper.class, VideoStatisticsMapper.class,
        VideoThumbnailMapper.class, VideoThumbnailsMapper.class})
public interface VideoSnippetMapper {
    VideoSnippetMapper INSTANCE = Mappers.getMapper(VideoSnippetMapper.class);

    VideoSnippetDTO toVideoSnippetDto(VideoSnippet videoSnippet);
    VideoSnippet toVideoSnippetEntity(VideoSnippetDTO videoSnippetDTO);


}
