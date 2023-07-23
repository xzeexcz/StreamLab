package kz.bitlab.streamlab.api.serialization;

import kz.bitlab.streamlab.entities.impls.Video;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalTime;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

public interface VideoSerialization {
    Video importVideoToDataBase(JsonNode jsonNode,
                                LocalTime runTime,
                                Date releaseDate,
                                double rating);
    Video updateMovie(String url, Map<String, Object> request, Optional<Video> optionalVideo);
}
