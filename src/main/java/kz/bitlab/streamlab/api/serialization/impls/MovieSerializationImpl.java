package kz.bitlab.streamlab.api.serialization.impls;

import kz.bitlab.streamlab.api.serialization.MovieSerialization;
import kz.bitlab.streamlab.api.serialization.MovieSnippetSerialization;
import kz.bitlab.streamlab.api.serialization.MovieStatisticsSerialization;
import kz.bitlab.streamlab.api.serialization.MovieThumbnailsSerialization;
import kz.bitlab.streamlab.entities.impls.Genres;
import kz.bitlab.streamlab.entities.impls.Movie;
import kz.bitlab.streamlab.respository.GenresRepository;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MovieSerializationImpl implements MovieSerialization {
    private final GenresRepository genresRepository;
    private final MovieThumbnailsSerialization movieThumbnailsSerialization;
    private final MovieStatisticsSerialization movieStatisticsSerialization;
    private final MovieSnippetSerialization movieSnippetSerialization;
    @Override
    public Movie importMovieToDataBase(JsonNode jsonNode, List<Long> genresId, LocalTime runTime, Date releaseDate, double rating) {
        if (jsonNode != null && !genresId.isEmpty() &&
                runTime != null && releaseDate != null
                && rating != 0) {
            Movie movie = new Movie();
            movie.setMovieId(jsonNode.get("id").asText());
            List<Genres> genresList = new ArrayList<>();
            for (Long id : genresId) {
                Genres genres = genresRepository.findById(id).orElse(
                        new Genres("Comedy"));
                genresList.add(genres);
            }
            movie.setGenres(genresList);
            movie.setMovieSnippet(movieSnippetSerialization.
                    importMovieSnippetToDataBase(jsonNode, runTime, releaseDate, rating));
            movie.setMovieStatistics(movieStatisticsSerialization.
                    importMovieStatisticsToDataBase(jsonNode));
            movie.setThumbnails(movieThumbnailsSerialization.
                    importThumbnailsToDataBase(jsonNode));
            return movie;
        } else {
            return null;
        }
    }

    @Override
    public Movie updateMovie(String movieId, Map<String, Object> request, Optional<Movie> optionalMovie) {
        if(optionalMovie.isPresent()) {
            Movie currentMovie = optionalMovie.get();
            if (request.containsKey("movieTitle")) {
                currentMovie.getMovieSnippet().setTitle((String) request.get("movieTitle"));
            }
            if (request.containsKey("movieDescription")) {
                currentMovie.getMovieSnippet().setDescription((String) request.get("movieDescription"));
            }
            if (request.containsKey("movieViewsCount")) {
                String viewsCountStr = (String) request.get("movieViewsCount");
                Integer viewsCount = Integer.valueOf(viewsCountStr);
                currentMovie.getMovieStatistics().setViewsCount(viewsCount.longValue());
            }
            if (request.containsKey("movieLikesCount")) {
                String likesCountStr = (String) request.get("movieLikesCount");
                Integer likesCount = Integer.valueOf(likesCountStr);
                currentMovie.getMovieStatistics().setLikesCount(likesCount.longValue());
            }
            return currentMovie;
        } else {
            return null;
        }
    }
}
