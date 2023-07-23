package kz.bitlab.streamlab;

import kz.bitlab.streamlab.dto.*;
import kz.bitlab.streamlab.entities.impls.*;
import kz.bitlab.streamlab.mapper.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class MovieMapperTest {

    @Autowired
    MovieMapper movieMapper;

    @Test
    public void testToMovieDto() {
        Movie movieEntity = new Movie();
        movieEntity.setMovieId("SfqvJKuOgHk");
        MovieSnippet movieSnippet = new MovieSnippet();
        movieSnippet.setDescription("Test description");
        movieSnippet.setTitle("Test title");
        movieSnippet.setRating(8.5);
        movieSnippet.setRunTime(LocalTime.of(10,30));
        movieSnippet.setReleaseDate(new Date());
        movieSnippet.setDefaultLanguage("en");
        movieSnippet.setDefaultAudioLanguage("en");
        MovieStatistics movieStatistics = new MovieStatistics();
        movieStatistics.setLikesCount(30000L);
        movieStatistics.setViewsCount(30000L);
        Thumbnails thumbnails = new Thumbnails();
        Thumbnail thumbnail = new Thumbnail();
        thumbnail.setHeight(30);
        thumbnail.setWidth(30);
        thumbnail.setUrl("https://url.com/something");
        thumbnails.setDefaultThumbnail(thumbnail);
        thumbnails.setMaxresThumbnail(thumbnail);
        thumbnails.setHighThumbnail(thumbnail);
        thumbnails.setMediumThumbnail(thumbnail);
        thumbnails.setStandardThumbnail(thumbnail);
        List<Genres> genres = new ArrayList<>();
        genres.add(new Genres("Comedy"));
        genres.add(new Genres("Horror"));
        movieEntity.setGenres(genres);
        movieEntity.setMovieSnippet(movieSnippet);
        movieEntity.setThumbnails(thumbnails);
        movieEntity.setMovieStatistics(movieStatistics);

        MovieDTO movieDTO = movieMapper.toMovieDto(movieEntity);
        Assertions.assertNotNull(movieDTO.getMovieId(),"not null");
        Assertions.assertNotNull(movieDTO.getGenresDTOList(),"not null");
        Assertions.assertNotNull(movieDTO.getMovieSnippetDTO(),"not null");
        Assertions.assertNotNull(movieDTO.getMovieStatisticsDTO(),"not null");
        Assertions.assertNotNull(movieDTO.getThumbnailsDTO(),"not null");
        Assertions.assertNotNull(movieDTO.getThumbnailsDTO().getDefaultThumbnail(),"not null");
        Assertions.assertNotNull(movieDTO.getThumbnailsDTO().getHighThumbnail(),"not null");
        Assertions.assertNotNull(movieDTO.getThumbnailsDTO().getMaxresThumbnail(),"not null");
        Assertions.assertNotNull(movieDTO.getThumbnailsDTO().getMediumThumbnail(),"not null");
        Assertions.assertNotNull(movieDTO.getThumbnailsDTO().getStandardThumbnail(),"not null");
    }

    @Test
    public void testToMovieEntity() {
        MovieDTO movieDTO = new MovieDTO();
        MovieSnippetDTO movieSnippetDTO = new MovieSnippetDTO();
        MovieStatisticsDTO movieStatisticsDTO = new MovieStatisticsDTO();
        ThumbnailDTO thumbnailDTO = new ThumbnailDTO();
        ThumbnailsDTO thumbnailsDTO = new ThumbnailsDTO();
        List<GenresDTO> genresDTOList = new ArrayList<>();

        thumbnailDTO.setHeight(30);
        thumbnailDTO.setWidth(30);
        thumbnailDTO.setUrl("https://url.com/something");
        thumbnailsDTO.setDefaultThumbnail(thumbnailDTO);
        thumbnailsDTO.setMaxresThumbnail(thumbnailDTO);
        thumbnailsDTO.setHighThumbnail(thumbnailDTO);
        thumbnailsDTO.setStandardThumbnail(thumbnailDTO);
        thumbnailsDTO.setMediumThumbnail(thumbnailDTO);

        movieStatisticsDTO.setLikesCount(300000L);
        movieStatisticsDTO.setViewsCount(300000L);

        movieSnippetDTO.setDescription("Test Description");
        movieSnippetDTO.setTitle("Test title");
        movieSnippetDTO.setRating(8.5);
        movieSnippetDTO.setDefaultLanguage("ru");
        movieSnippetDTO.setDefaultAudioLanguage("en");
        movieSnippetDTO.setReleaseDate(new Date());
        movieSnippetDTO.setRunTime(LocalTime.of(12,50));

        genresDTOList.add(new GenresDTO(1L,"Comedy"));
        genresDTOList.add(new GenresDTO(2L, "Adventure"));

        movieDTO.setMovieId("SfqvJKuOgHk");
        movieDTO.setGenresDTOList(genresDTOList);
        movieDTO.setThumbnailsDTO(thumbnailsDTO);
        movieDTO.setMovieSnippetDTO(movieSnippetDTO);
        movieDTO.setMovieStatisticsDTO(movieStatisticsDTO);

        Movie movie = movieMapper.toMovieEntity(movieDTO);
        Assertions.assertNotNull(movie.getMovieId(),"not null");
        Assertions.assertNotNull(movie.getGenres(),"not null");
        Assertions.assertNotNull(movie.getMovieSnippet(),"not null");
        Assertions.assertNotNull(movie.getMovieStatistics(),"not null");
        Assertions.assertNotNull(movie.getThumbnails(),"not null");
        Assertions.assertNotNull(movie.getThumbnails().getDefaultThumbnail(),"not null");
        Assertions.assertNotNull(movie.getThumbnails().getHighThumbnail(),"not null");
        Assertions.assertNotNull(movie.getThumbnails().getMaxresThumbnail(),"not null");
        Assertions.assertNotNull(movie.getThumbnails().getMediumThumbnail(),"not null");
        Assertions.assertNotNull(movie.getThumbnails().getStandardThumbnail(),"not null");
    }
    @Test
    public void movieEntityToDtoList() {
        Movie movieEntity = new Movie();
        movieEntity.setMovieId("SfqvJKuOgHk");
        MovieSnippet movieSnippet = new MovieSnippet();
        movieSnippet.setDescription("Test description");
        movieSnippet.setTitle("Test title");
        movieSnippet.setRating(8.5);
        movieSnippet.setRunTime(LocalTime.of(10,30));
        movieSnippet.setReleaseDate(new Date());
        movieSnippet.setDefaultLanguage("en");
        movieSnippet.setDefaultAudioLanguage("en");
        MovieStatistics movieStatistics = new MovieStatistics();
        movieStatistics.setLikesCount(30000L);
        movieStatistics.setViewsCount(30000L);
        Thumbnails thumbnails = new Thumbnails();
        Thumbnail thumbnail = new Thumbnail();
        thumbnail.setHeight(30);
        thumbnail.setWidth(30);
        thumbnail.setUrl("https://url.com/something");
        thumbnails.setDefaultThumbnail(thumbnail);
        thumbnails.setMaxresThumbnail(thumbnail);
        thumbnails.setHighThumbnail(thumbnail);
        thumbnails.setMediumThumbnail(thumbnail);
        thumbnails.setStandardThumbnail(thumbnail);
        List<Genres> genres = new ArrayList<>();
        genres.add(new Genres("Comedy"));
        genres.add(new Genres("Horror"));
        movieEntity.setGenres(genres);
        movieEntity.setMovieSnippet(movieSnippet);
        movieEntity.setThumbnails(thumbnails);
        movieEntity.setMovieStatistics(movieStatistics);

        List<Movie> movies = new ArrayList<>();
        movies.add(movieEntity);
        movies.add(movieEntity);
        movies.add(movieEntity);
        movies.add(movieEntity);
        List<MovieDTO> movieDTOS = movieMapper.toMovieDtoList(movies);

        Assertions.assertNotNull(movieDTOS);
        for(int i = 0; i < movieDTOS.size(); i++) {
            Assertions.assertNotNull(movieDTOS.get(i).getMovieStatisticsDTO());
            Assertions.assertNotNull(movieDTOS.get(i).getMovieId());
            Assertions.assertNotNull(movieDTOS.get(i).getMovieSnippetDTO());
            Assertions.assertNotNull(movieDTOS.get(i).getThumbnailsDTO());
            Assertions.assertNotNull(movieDTOS.get(i).getGenresDTOList());
        }
    }

    @Test
    public void toMovieEntityList() {
        MovieDTO movieDTO = new MovieDTO();
        MovieSnippetDTO movieSnippetDTO = new MovieSnippetDTO();
        MovieStatisticsDTO movieStatisticsDTO = new MovieStatisticsDTO();
        ThumbnailDTO thumbnailDTO = new ThumbnailDTO();
        ThumbnailsDTO thumbnailsDTO = new ThumbnailsDTO();
        List<GenresDTO> genresDTOList = new ArrayList<>();

        thumbnailDTO.setHeight(30);
        thumbnailDTO.setWidth(30);
        thumbnailDTO.setUrl("https://url.com/something");
        thumbnailsDTO.setDefaultThumbnail(thumbnailDTO);
        thumbnailsDTO.setMaxresThumbnail(thumbnailDTO);
        thumbnailsDTO.setHighThumbnail(thumbnailDTO);
        thumbnailsDTO.setStandardThumbnail(thumbnailDTO);
        thumbnailsDTO.setMediumThumbnail(thumbnailDTO);

        movieStatisticsDTO.setLikesCount(300000L);
        movieStatisticsDTO.setViewsCount(300000L);

        movieSnippetDTO.setDescription("Test Description");
        movieSnippetDTO.setTitle("Test title");
        movieSnippetDTO.setRating(8.5);
        movieSnippetDTO.setDefaultLanguage("ru");
        movieSnippetDTO.setDefaultAudioLanguage("en");
        movieSnippetDTO.setReleaseDate(new Date());
        movieSnippetDTO.setRunTime(LocalTime.of(12,50));

        genresDTOList.add(new GenresDTO(1L,"Comedy"));
        genresDTOList.add(new GenresDTO(2L, "Adventure"));

        movieDTO.setMovieId("SfqvJKuOgHk");
        movieDTO.setGenresDTOList(genresDTOList);
        movieDTO.setThumbnailsDTO(thumbnailsDTO);
        movieDTO.setMovieSnippetDTO(movieSnippetDTO);
        movieDTO.setMovieStatisticsDTO(movieStatisticsDTO);

        List<MovieDTO> movieDTOS = new ArrayList<>();
        movieDTOS.add(movieDTO);
        movieDTOS.add(movieDTO);
        movieDTOS.add(movieDTO);

        List<Movie> movies = movieMapper.toMovieEntityList(movieDTOS);

        Assertions.assertNotNull(movies);
        for(int i = 0; i < movies.size(); i++)  {
            Assertions.assertNotNull(movies.get(i).getMovieId());
            Assertions.assertNotNull(movies.get(i).getMovieSnippet());
            Assertions.assertNotNull(movies.get(i).getMovieStatistics());
            Assertions.assertNotNull(movies.get(i).getGenres());
            Assertions.assertNotNull(movies.get(i).getThumbnails());
        }
    }
}
