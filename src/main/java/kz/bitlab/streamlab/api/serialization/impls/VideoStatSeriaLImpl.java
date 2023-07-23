package kz.bitlab.streamlab.api.serialization.impls;

import kz.bitlab.streamlab.api.serialization.VideoStatisticsSerialization;
import kz.bitlab.streamlab.entities.impls.VideoStatistics;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VideoStatSeriaLImpl implements VideoStatisticsSerialization {
        @Override
        public VideoStatistics importVideoStatisticsToDataBase(JsonNode jsonNode) {
            if(jsonNode == null) {
                return null;
            }
            VideoStatistics videoStatistics = new VideoStatistics();
            if (jsonNode.get("statistics").get("likeCount").asLong() == 0) {
                videoStatistics.setLikesCount(20312L);
            } else {
                videoStatistics.setLikesCount(
                        jsonNode.get("statistics").get("likeCount").asLong());
            }
            if (jsonNode.get("statistics").get("viewCount").asLong() == 0) {
                videoStatistics.setViewsCount(221321L);
            } else {
                videoStatistics.setViewsCount(jsonNode.get("statistics").get("viewCount").asLong());
            }
            return videoStatistics;
        }
}
