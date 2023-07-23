package kz.bitlab.streamlab.mapper;

import kz.bitlab.streamlab.dto.MovieSnippetDTO;
import kz.bitlab.streamlab.entities.impls.MovieSnippet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring" , uses = { MovieStatisticsMapper.class,
        ThumbnailsMapper.class, GenresMapper.class, MovieMapper.class})
public interface MovieSnippetMapper {

    MovieSnippetMapper INSTANCE = Mappers.getMapper(MovieSnippetMapper.class);

    MovieSnippetDTO toMovieSnippetDto(MovieSnippet movieSnippet);
    MovieSnippet toMovieSnippetEntity(MovieSnippetDTO movieSnippetDTO);
    List<MovieSnippetDTO> toMovieSnippetDtoList(List<MovieSnippet> movieSnippetList);
    List<MovieSnippet> toMovieSnippetEntityList(List<MovieSnippetDTO> movieSnippetDTOS);

}
