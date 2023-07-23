package kz.bitlab.streamlab.services;

import kz.bitlab.streamlab.dto.MovieDTO;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MovieService {

    MovieDTO addMovieToDataBase(String videoId,
                             List<Long> genresId,
                             LocalTime runTime, Date releaseDate,
                             double rating) throws GeneralSecurityException, IOException;
    MovieDTO getOneMovieDtoFromDataBase(String videoId);
    List<MovieDTO> getMoviesDtoFromDataBase();

    void deleteMoviesFromDataBase(String url);


    MovieDTO updateMovie(String movieId, Map<String, Object> request);

}
