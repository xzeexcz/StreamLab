package kz.bitlab.streamlab.api.serialization;

import kz.bitlab.streamlab.entities.impls.VideoStatistics;
import com.fasterxml.jackson.databind.JsonNode;


public interface VideoStatisticsSerialization {
    VideoStatistics importVideoStatisticsToDataBase(JsonNode jsonNode);
}
