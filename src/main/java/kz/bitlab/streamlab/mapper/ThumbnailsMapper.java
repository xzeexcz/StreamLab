package kz.bitlab.streamlab.mapper;

import kz.bitlab.streamlab.dto.ThumbnailDTO;
import kz.bitlab.streamlab.dto.ThumbnailsDTO;
import kz.bitlab.streamlab.entities.impls.Thumbnails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MovieSnippetMapper.class, MovieStatisticsMapper.class,
        ThumbnailsMapper.class, GenresMapper.class})
public interface ThumbnailsMapper {
    ThumbnailsMapper INSTANCE = Mappers.getMapper(ThumbnailsMapper.class);
    ThumbnailsDTO toThumbnailsDto(Thumbnails thumbnails);
    Thumbnails toThumbnailsEntity(ThumbnailsDTO thumbnailsDTO);
    List<ThumbnailDTO> toThumbnailsDtoList(List<Thumbnails> thumbnailsList);
    List<Thumbnails> toThumbnailsEntityList(List<ThumbnailsDTO> thumbnailsDTOList);
}
