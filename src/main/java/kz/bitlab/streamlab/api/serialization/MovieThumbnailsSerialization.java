package kz.bitlab.streamlab.api.serialization;

import kz.bitlab.streamlab.entities.impls.Thumbnails;
import com.fasterxml.jackson.databind.JsonNode;

public interface MovieThumbnailsSerialization {
    Thumbnails importThumbnailsToDataBase(JsonNode jsonNode);
}
