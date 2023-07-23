package kz.bitlab.streamlab.services.impls;

import kz.bitlab.streamlab.api.YoutubeAPIClient;
import kz.bitlab.streamlab.api.serialization.VideoSerialization;
import kz.bitlab.streamlab.dto.videos.VideoDTO;
import kz.bitlab.streamlab.mapper.videos.VideoMapper;
import kz.bitlab.streamlab.respository.videos.VideoRepository;
import kz.bitlab.streamlab.services.VideoService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.youtube.model.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {
    private final VideoSerialization videoSerialization;
    private final VideoRepository videoRepository;
    private final YoutubeAPIClient youtubeAPIClient;
    private final VideoMapper videoMapper;
    @Override
    public void addVideoToDataBase(String videoId, LocalTime runTime, Date releaseDate, double rating)
            throws GeneralSecurityException, IOException {
        Video video = youtubeAPIClient.getVideoDetails(videoId);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.valueToTree(video);
        if(jsonNode !=null) {
            videoRepository.save(
                    videoSerialization.importVideoToDataBase(jsonNode,runTime,releaseDate,rating));
        } else {
            throw new IOException();
        }
    }

    @Override
    public List<VideoDTO> getVideosFromDataBase() {
        return videoMapper.toVideoDTOList(videoRepository.findAll());
    }

    @Override
    public VideoDTO getOneMovieFromDataBase(String videoId) {
        return videoMapper.toVideoDto(videoRepository.getVideoByUrl(videoId));
    }

    @Override
    public VideoDTO updateVideo(String url, Map<String, Object> request) {
        Optional<kz.bitlab.streamlab.entities.impls.Video> optionalVideo = Optional.ofNullable
                (videoRepository.getVideoByUrl(url));
        kz.bitlab.streamlab.entities.impls.Video video = videoSerialization.updateMovie(url,request,optionalVideo);
        if(video!=null) {
            return videoMapper.toVideoDto(videoRepository.save(video));
        } else {
            return null;
        }
    }

    @Override
    public void deleteVideoFromDataBase(String url) {
        kz.bitlab.streamlab.entities.impls.Video video = videoRepository.getVideoByUrl(url);
        if(video!=null) {
            videoRepository.delete(video);
        }
    }
}
