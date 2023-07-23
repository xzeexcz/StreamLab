package kz.bitlab.streamlab.services.impls;

import kz.bitlab.streamlab.api.YoutubeAPIClient;
import kz.bitlab.streamlab.api.serialization.MovieStatisticsSerialization;
import kz.bitlab.streamlab.respository.MovieStatisticsRepository;
import kz.bitlab.streamlab.services.MovieStatisticsService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.youtube.model.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Service
@RequiredArgsConstructor
public class MovieStatisticsImpl implements MovieStatisticsService {
    private final YoutubeAPIClient youtubeAPIClient;
    private final MovieStatisticsSerialization movieStatisticsSerialization;
    private final MovieStatisticsRepository movieStatisticsRepository;

    @Override
    public void home(String videoId) throws GeneralSecurityException, IOException {
        Video video = youtubeAPIClient.getVideoDetails(videoId);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.valueToTree(video);
        if(jsonNode!=null) {
            movieStatisticsRepository.save(
                    movieStatisticsSerialization.importMovieStatisticsToDataBase(jsonNode));
        } else {
            throw new IOException();
        }
    }
}
