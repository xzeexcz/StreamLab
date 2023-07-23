package kz.bitlab.streamlab.api;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTubeRequestInitializer;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Service
public class YoutubeAPIClient {
    private static final String API_KEY = "AIzaSyBnwcnt8Ge7HemNZ9rLni_iZOtnYeNYCqM";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String APPLICATION_NAME = "Youtube";
    private static YouTube youtube;

    public Video getVideoDetails(String videoId) throws GeneralSecurityException, IOException {
        youtube = getService(API_KEY);
        Video video = getVideoById(videoId);
        return video;
    }

    private static YouTube getService(String API_KEY) throws GeneralSecurityException, IOException {
        final HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new YouTube.Builder(httpTransport, JSON_FACTORY, null)
                .setApplicationName(APPLICATION_NAME)
                .setYouTubeRequestInitializer(new YouTubeRequestInitializer(API_KEY))
                .build();
    }

    private static Video getVideoById(String videoId) throws IOException {
        YouTube.Videos.List request = youtube.videos().list("snippet,statistics");
        request.setId(videoId);
        VideoListResponse response = request.execute();
        return response.getItems().get(0);
    }

}
