package kz.bitlab.streamlab.api.serialization;

import kz.bitlab.streamlab.entities.impls.Movie;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MovieSerialization {
    Movie importMovieToDataBase(JsonNode jsonNode,
                                List<Long> castsId,
                                LocalTime runTime,
                                Date releaseDate,
                                double rating);
    Movie updateMovie(String movieId, Map<String, Object> request, Optional<Movie> optionalMovie);
}
