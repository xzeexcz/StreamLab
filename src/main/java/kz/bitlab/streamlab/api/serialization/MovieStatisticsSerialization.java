package kz.bitlab.streamlab.api.serialization;

import kz.bitlab.streamlab.entities.impls.MovieStatistics;
import com.fasterxml.jackson.databind.JsonNode;

public interface MovieStatisticsSerialization {
    MovieStatistics importMovieStatisticsToDataBase(JsonNode jsonNode);
}
