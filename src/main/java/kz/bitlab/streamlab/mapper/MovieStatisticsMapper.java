package kz.bitlab.streamlab.mapper;

import kz.bitlab.streamlab.dto.MovieSnippetDTO;
import kz.bitlab.streamlab.dto.MovieStatisticsDTO;
import kz.bitlab.streamlab.entities.impls.MovieStatistics;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MovieSnippetMapper.class, MovieStatisticsMapper.class,
        ThumbnailsMapper.class, GenresMapper.class})
public interface MovieStatisticsMapper {
    MovieStatisticsMapper INSTANCE = Mappers.getMapper(MovieStatisticsMapper.class);
    MovieStatisticsDTO toMovieStatisticsDto(MovieStatistics movieStatistics);
    MovieStatistics toMovieStatisticsEntity(MovieSnippetDTO movieSnippetDTO);
    List<MovieStatisticsDTO> toMovieStatisticsDtoList(List<MovieStatistics> movieStatisticsList);
    List<MovieStatistics> toMovieStatisticsEntityList(List<MovieStatisticsDTO> movieStatisticsDTOS);
}
