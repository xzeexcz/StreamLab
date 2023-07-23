package kz.bitlab.streamlab.services.impls;

import kz.bitlab.streamlab.api.YoutubeAPIClient;
import kz.bitlab.streamlab.api.serialization.MovieSerialization;
import kz.bitlab.streamlab.dto.MovieDTO;
import kz.bitlab.streamlab.entities.impls.Movie;
import kz.bitlab.streamlab.mapper.MovieMapper;
import kz.bitlab.streamlab.respository.GenresRepository;
import kz.bitlab.streamlab.respository.MovieRepository;
import kz.bitlab.streamlab.services.MovieService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.youtube.model.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final YoutubeAPIClient youtubeAPIClient;
    private final MovieRepository movieRepository;
    private final MovieSerialization movieSerialization;
    private final MovieMapper movieMapper;
    private final GenresRepository genresRepository;

    @Override
    public MovieDTO addMovieToDataBase(String videoId,
                                    List<Long> genresId,
                                    LocalTime runTime, Date releaseDate,
                                    double rating) throws GeneralSecurityException, IOException {
        Video video = youtubeAPIClient.getVideoDetails(videoId);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.valueToTree(video);
        if(jsonNode!=null) {
            return movieMapper.toMovieDto(movieRepository.save(movieSerialization.importMovieToDataBase(jsonNode,
                    genresId,runTime,releaseDate,rating)));
        } else  {
            throw new IOException();
        }
    }

    @Override
    public MovieDTO getOneMovieDtoFromDataBase(String videoId) {
        return movieMapper.toMovieDto(movieRepository.findByMovieId(videoId));
    }

    @Override
    public List<MovieDTO> getMoviesDtoFromDataBase() {
        return movieMapper.toMovieDtoList(movieRepository.findAll());
    }

    @Override
    public void deleteMoviesFromDataBase(String url) {
            Movie movie = movieRepository.findByMovieId(url);
            if(movie !=null) {
                movie.setGenres(null);
                movieRepository.deleteById(movie.getId());
            }
    }

    @Override
    public MovieDTO updateMovie(String movieId, Map<String, Object> request) {
        Optional<Movie> optionalMovie = Optional.ofNullable(movieRepository.findByMovieId(movieId));

        Movie movie = movieSerialization.updateMovie(movieId,request,optionalMovie);
        if(movie != null) {
            return movieMapper.toMovieDto(movieRepository.save(movie));
        } else {
            return null;
        }
    }
}
