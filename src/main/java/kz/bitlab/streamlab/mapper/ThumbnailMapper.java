package kz.bitlab.streamlab.mapper;

import kz.bitlab.streamlab.dto.ThumbnailDTO;
import kz.bitlab.streamlab.entities.impls.Thumbnail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MovieSnippetMapper.class, MovieStatisticsMapper.class,
        ThumbnailsMapper.class, GenresMapper.class})
public interface ThumbnailMapper {
    ThumbnailMapper INSTANCE = Mappers.getMapper(ThumbnailMapper.class);
    ThumbnailDTO toThumbnailDto(Thumbnail thumbnail);
    Thumbnail toThumbnailEntity(ThumbnailDTO thumbnailDTO);
    List<ThumbnailDTO> toThumbnailDtoList(List<Thumbnail> thumbnailList);
    List<Thumbnail> toThumbnailEntityList(List<ThumbnailDTO> thumbnailDTOList);
}
