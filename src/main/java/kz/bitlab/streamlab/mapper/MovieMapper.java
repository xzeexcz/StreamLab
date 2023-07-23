package kz.bitlab.streamlab.mapper;

import kz.bitlab.streamlab.dto.MovieDTO;
import kz.bitlab.streamlab.entities.impls.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MovieSnippetMapper.class, MovieStatisticsMapper.class,
        ThumbnailsMapper.class, GenresMapper.class})
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
    @Mapping(source = "movieSnippet", target = "movieSnippetDTO")
    @Mapping(source = "movieStatistics", target = "movieStatisticsDTO")
    @Mapping(source = "thumbnails", target = "thumbnailsDTO")
    @Mapping(source = "genres", target = "genresDTOList")
    MovieDTO toMovieDto(Movie movie);
    @Mapping(source = "movieSnippetDTO", target = "movieSnippet")
    @Mapping(source = "movieStatisticsDTO", target = "movieStatistics")
    @Mapping(source = "thumbnailsDTO", target = "thumbnails")
    @Mapping(source = "genresDTOList", target = "genres")
    Movie toMovieEntity(MovieDTO movieDTO);
    List<MovieDTO> toMovieDtoList(List<Movie> movieList);
    List<Movie> toMovieEntityList(List<MovieDTO> movieDTOList);
}
