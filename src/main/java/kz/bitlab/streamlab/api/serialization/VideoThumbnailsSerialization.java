package kz.bitlab.streamlab.api.serialization;

import kz.bitlab.streamlab.entities.impls.VideoThumbnails;
import com.fasterxml.jackson.databind.JsonNode;

public interface VideoThumbnailsSerialization {
    VideoThumbnails importVideoThumbnailsToDataBase(JsonNode jsonNode);
}
