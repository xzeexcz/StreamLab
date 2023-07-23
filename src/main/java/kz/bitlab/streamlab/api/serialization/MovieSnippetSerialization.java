package kz.bitlab.streamlab.api.serialization;

import kz.bitlab.streamlab.entities.impls.MovieSnippet;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalTime;
import java.util.Date;

public interface MovieSnippetSerialization {
    MovieSnippet importMovieSnippetToDataBase(JsonNode jsonNode,
                                              LocalTime runTime, Date releaseDate,
                                              double rating);
}
