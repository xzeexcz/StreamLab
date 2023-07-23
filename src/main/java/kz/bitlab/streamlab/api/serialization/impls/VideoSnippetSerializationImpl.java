package kz.bitlab.streamlab.api.serialization.impls;

import kz.bitlab.streamlab.api.serialization.VideoSnippetSerialization;
import kz.bitlab.streamlab.entities.impls.VideoSnippet;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class VideoSnippetSerializationImpl  implements VideoSnippetSerialization {

    @Override
    public VideoSnippet importVideoSnippetToDataBase(JsonNode jsonNode, LocalTime runTime, Date releaseDate, double rating) {
        if(jsonNode == null) {
            return null;
        }
        if(runTime == null || releaseDate == null || rating == 0.0) {
            return null;
        }
        VideoSnippet videoSnippet = new VideoSnippet();
        videoSnippet.setRunTime(runTime);
        videoSnippet.setReleaseDate(releaseDate);
        videoSnippet.setRating(rating);
        if (jsonNode.get("snippet").get("defaultAudioLanguage") == null &&
                jsonNode.get("snippet").get("defaultAudioLanguage").isNull()) {
            videoSnippet.setDefaultAudioLanguage("en");
        } else {
            videoSnippet.setDefaultAudioLanguage(
                    jsonNode.get("snippet").get("defaultAudioLanguage").asText());
        }
        if (jsonNode.get("snippet").get("defaultLanguage") != null &&
                !jsonNode.get("snippet").get("defaultLanguage").isNull()) {
            videoSnippet.setDefaultLanguage(
                    jsonNode.get("snippet").get("defaultLanguage").asText());
        } else {
            videoSnippet.setDefaultLanguage("en");
        }
        if (jsonNode.get("snippet").get("description") == null &&
                jsonNode.get("snippet").get("description").isNull()) {
            videoSnippet.setDescription("Some description there...");
        } else {
            videoSnippet.setDescription(
                    jsonNode.get("snippet").get("description").asText());
        }
        if (jsonNode.get("snippet").get("title") == null &&
                jsonNode.get("snippet").get("title").isNull()) {
            videoSnippet.setTitle("Some title right there...");
        } else {
            videoSnippet.setTitle(
                    jsonNode.get("snippet").get("title").asText());
        }
        return videoSnippet;
    }
}
