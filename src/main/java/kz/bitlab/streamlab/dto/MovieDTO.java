package kz.bitlab.streamlab.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieDTO {
    private String movieId;
    private MovieSnippetDTO movieSnippetDTO;
    private MovieStatisticsDTO movieStatisticsDTO;
    private ThumbnailsDTO thumbnailsDTO;
    private List<GenresDTO> genresDTOList;
}
