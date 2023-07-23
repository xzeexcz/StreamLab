package kz.bitlab.streamlab.api.serialization.impls;

import kz.bitlab.streamlab.api.serialization.VideoThumbnailsSerialization;
import kz.bitlab.streamlab.entities.impls.VideoThumbnail;
import kz.bitlab.streamlab.entities.impls.VideoThumbnails;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VideoThumbnailsSerializationImpl implements VideoThumbnailsSerialization {
    @Override
    public VideoThumbnails importVideoThumbnailsToDataBase(JsonNode jsonNode) {
        if(jsonNode ==null) {
            return null;
        }
        VideoThumbnails videoThumbnails = new VideoThumbnails();
        if(jsonNode.get("snippet").get("thumbnails")!=null) {
            videoThumbnails.setDefaultThumbnail(new VideoThumbnail(
                    jsonNode.get("snippet").get("thumbnails").get("default").get("height").asInt(),
                    jsonNode.get("snippet").get("thumbnails").get("default").get("url").asText(),
                    jsonNode.get("snippet").get("thumbnails").get("default").get("width").asInt()));
            videoThumbnails.setHighThumbnail(new VideoThumbnail(
                    jsonNode.get("snippet").get("thumbnails").get("high").get("height").asInt(),
                    jsonNode.get("snippet").get("thumbnails").get("high").get("url").asText(),
                    jsonNode.get("snippet").get("thumbnails").get("high").get("width").asInt()));
            videoThumbnails.setMaxresThumbnail(new VideoThumbnail(
                    jsonNode.get("snippet").get("thumbnails").get("maxres").get("height").asInt(),
                    jsonNode.get("snippet").get("thumbnails").get("maxres").get("url").asText(),
                    jsonNode.get("snippet").get("thumbnails").get("maxres").get("width").asInt()));
            videoThumbnails.setMediumThumbnail(new VideoThumbnail(
                    jsonNode.get("snippet").get("thumbnails").get("medium").get("height").asInt(),
                    jsonNode.get("snippet").get("thumbnails").get("medium").get("url").asText(),
                    jsonNode.get("snippet").get("thumbnails").get("medium").get("width").asInt()));
            videoThumbnails.setStandardThumbnail(new VideoThumbnail(
                    jsonNode.get("snippet").get("thumbnails").get("standard").get("height").asInt(),
                    jsonNode.get("snippet").get("thumbnails").get("standard").get("url").asText(),
                    jsonNode.get("snippet").get("thumbnails").get("standard").get("width").asInt()));
            return videoThumbnails;
        } else {
            return null;
        }
    }
}
