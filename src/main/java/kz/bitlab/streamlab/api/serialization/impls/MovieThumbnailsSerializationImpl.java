package kz.bitlab.streamlab.api.serialization.impls;

import kz.bitlab.streamlab.api.serialization.MovieThumbnailsSerialization;
import kz.bitlab.streamlab.entities.impls.Thumbnail;
import kz.bitlab.streamlab.entities.impls.Thumbnails;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieThumbnailsSerializationImpl implements MovieThumbnailsSerialization {
    @Override
    public Thumbnails importThumbnailsToDataBase(JsonNode jsonNode) {
        if(jsonNode!=null) {
            Thumbnails thumbnails = new Thumbnails();
            if(jsonNode.get("snippet").get("thumbnails")!=null) {
                thumbnails.setDefaultThumbnail(new Thumbnail(
                        jsonNode.get("snippet").get("thumbnails").get("default").get("height").asInt(),
                        jsonNode.get("snippet").get("thumbnails").get("default").get("url").asText(),
                        jsonNode.get("snippet").get("thumbnails").get("default").get("width").asInt()));
                thumbnails.setHighThumbnail(new Thumbnail(
                        jsonNode.get("snippet").get("thumbnails").get("high").get("height").asInt(),
                        jsonNode.get("snippet").get("thumbnails").get("high").get("url").asText(),
                        jsonNode.get("snippet").get("thumbnails").get("high").get("width").asInt()));
                thumbnails.setMaxresThumbnail(new Thumbnail(
                        jsonNode.get("snippet").get("thumbnails").get("maxres").get("height").asInt(),
                        jsonNode.get("snippet").get("thumbnails").get("maxres").get("url").asText(),
                        jsonNode.get("snippet").get("thumbnails").get("maxres").get("width").asInt()));
                thumbnails.setMediumThumbnail(new Thumbnail(
                        jsonNode.get("snippet").get("thumbnails").get("medium").get("height").asInt(),
                        jsonNode.get("snippet").get("thumbnails").get("medium").get("url").asText(),
                        jsonNode.get("snippet").get("thumbnails").get("medium").get("width").asInt()));
                thumbnails.setStandardThumbnail(new Thumbnail(
                        jsonNode.get("snippet").get("thumbnails").get("standard").get("height").asInt(),
                        jsonNode.get("snippet").get("thumbnails").get("standard").get("url").asText(),
                        jsonNode.get("snippet").get("thumbnails").get("standard").get("width").asInt()));
                return thumbnails;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
