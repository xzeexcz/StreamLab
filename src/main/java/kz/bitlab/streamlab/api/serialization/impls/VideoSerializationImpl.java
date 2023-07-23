package kz.bitlab.streamlab.api.serialization.impls;

import kz.bitlab.streamlab.api.serialization.VideoSerialization;
import kz.bitlab.streamlab.api.serialization.VideoSnippetSerialization;
import kz.bitlab.streamlab.api.serialization.VideoStatisticsSerialization;
import kz.bitlab.streamlab.api.serialization.VideoThumbnailsSerialization;
import kz.bitlab.streamlab.entities.impls.Video;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VideoSerializationImpl implements VideoSerialization {

    private final VideoSnippetSerialization videoSnippetSerialization;
    private final VideoStatisticsSerialization videoStatisticsSerialization;
    private final VideoThumbnailsSerialization videoThumbnailsSerialization;
    @Override
    public Video importVideoToDataBase(JsonNode jsonNode, LocalTime runTime, Date releaseDate, double rating) {
        if(jsonNode == null) {
            return null;
        }
        if(runTime != null || releaseDate !=null || rating != 0.0) {
            Video video = new Video();
            video.setUrl(jsonNode.get("id").asText());
            if(videoSnippetSerialization.importVideoSnippetToDataBase(jsonNode, runTime, releaseDate, rating) != null) {
                video.setVideoSnippet(
                        videoSnippetSerialization.importVideoSnippetToDataBase(jsonNode, runTime, releaseDate, rating));
            }
            if(videoStatisticsSerialization.importVideoStatisticsToDataBase(jsonNode) != null) {
                video.setVideoStatistics(
                        videoStatisticsSerialization.importVideoStatisticsToDataBase(jsonNode));
            }
            if(videoThumbnailsSerialization.importVideoThumbnailsToDataBase(jsonNode) != null) {
                video.setVideoThumbnails(
                        videoThumbnailsSerialization.importVideoThumbnailsToDataBase(jsonNode));
            }
            return video;
        } else {
            return null;
        }
    }

    @Override
    public Video updateMovie(String url, Map<String, Object> request, Optional<Video> optionalVideo) {
        if(optionalVideo.isPresent()) {
            Video currentVideo = optionalVideo.get();
            if (request.containsKey("videoTitle")) {
                currentVideo.getVideoSnippet().setTitle((String) request.get("videoTitle"));
            }
            if (request.containsKey("videoDescription")) {
                currentVideo.getVideoSnippet().setDescription((String) request.get("videoDescription"));
            }
            if (request.containsKey("videoViewsCount")) {
                String viewsCountStr = (String) request.get("videoViewsCount");
                Integer viewsCount = Integer.valueOf(viewsCountStr);
                currentVideo.getVideoStatistics().setViewsCount(viewsCount.longValue());
            }
            if (request.containsKey("videoLikesCount")) {
                String likesCountStr = (String) request.get("videoLikesCount");
                Integer likesCount = Integer.valueOf(likesCountStr);
                currentVideo.getVideoStatistics().setLikesCount(likesCount.longValue());
            }
            return currentVideo;
        } else {
            return null;
        }
    }
}
