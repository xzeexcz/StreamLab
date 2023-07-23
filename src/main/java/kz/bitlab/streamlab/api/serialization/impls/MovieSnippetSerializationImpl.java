package kz.bitlab.streamlab.api.serialization.impls;

import kz.bitlab.streamlab.api.serialization.MovieSnippetSerialization;
import kz.bitlab.streamlab.entities.impls.MovieSnippet;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class MovieSnippetSerializationImpl implements MovieSnippetSerialization {
    @Override
    public MovieSnippet importMovieSnippetToDataBase(JsonNode jsonNode, LocalTime runTime, Date releaseDate, double rating) {
        if(jsonNode!=null) {
            MovieSnippet movieSnippet = new MovieSnippet();
            if(runTime != null && releaseDate !=null && rating != 0.0) {
                movieSnippet.setRunTime(runTime);
                movieSnippet.setReleaseDate(releaseDate);
                movieSnippet.setRating(rating);
            } else {
                throw new IllegalArgumentException();
            }
            if (jsonNode.get("snippet").get("defaultAudioLanguage") == null) {
                movieSnippet.setDefaultAudioLanguage("en");
            } else {
                movieSnippet.setDefaultAudioLanguage(
                        jsonNode.get("snippet").get("defaultAudioLanguage").asText());
            }
            if (jsonNode.get("snippet").get("defaultLanguage") != null &&
                    !jsonNode.get("snippet").get("defaultLanguage").isNull()) {
                movieSnippet.setDefaultLanguage(
                        jsonNode.get("snippet").get("defaultLanguage").asText());
            } else {
                movieSnippet.setDefaultLanguage("en");
            }
            if (jsonNode.get("snippet").get("description") == null &&
                    jsonNode.get("snippet").get("description").isNull()) {
                movieSnippet.setDescription("Some description there...");
            } else {
                movieSnippet.setDescription(
                        jsonNode.get("snippet").get("description").asText());
            }
            if (jsonNode.get("snippet").get("title") == null &&
                    jsonNode.get("snippet").get("title").isNull()) {
                movieSnippet.setTitle("Some title right there...");
            } else {
                movieSnippet.setTitle(
                        jsonNode.get("snippet").get("title").asText());
            }
            return movieSnippet;
        } else {
            return null;
        }
    }
}
