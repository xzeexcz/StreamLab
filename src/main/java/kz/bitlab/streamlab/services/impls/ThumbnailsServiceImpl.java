package kz.bitlab.streamlab.services.impls;

import kz.bitlab.streamlab.api.YoutubeAPIClient;
import kz.bitlab.streamlab.api.serialization.MovieThumbnailsSerialization;
import kz.bitlab.streamlab.respository.ThumbnailsRepository;
import kz.bitlab.streamlab.services.ThumbnailsService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.youtube.model.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Service
@RequiredArgsConstructor
public class ThumbnailsServiceImpl implements ThumbnailsService {
    private final YoutubeAPIClient youtubeAPIClient;
    private final ThumbnailsRepository thumbnailsRepository;
    private final MovieThumbnailsSerialization movieThumbnailsSerialization;

    @Override
    public void home(String videoId) throws GeneralSecurityException, IOException {
        Video video = youtubeAPIClient.getVideoDetails(videoId);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.valueToTree(video);
        if(jsonNode!=null) {
            thumbnailsRepository.save(movieThumbnailsSerialization.importThumbnailsToDataBase(jsonNode));
        } else {
            throw new IOException();
        }
    }
}
