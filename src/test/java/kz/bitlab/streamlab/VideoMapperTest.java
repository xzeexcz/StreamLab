package kz.bitlab.streamlab;


import kz.bitlab.streamlab.dto.videos.*;
import kz.bitlab.streamlab.entities.impls.*;
import kz.bitlab.streamlab.mapper.videos.VideoMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class VideoMapperTest {
    @Autowired
    private VideoMapper videoMapper;

    @Test
    public void VideoEntityToDto() {
        Video video = new Video();
        VideoSnippet videoSnippet = new VideoSnippet();
        VideoStatistics videoStatistics = new VideoStatistics();
        VideoThumbnails videoThumbnails = new VideoThumbnails();
        VideoThumbnail videoThumbnail = new VideoThumbnail();
        video.setUrl("SfqvJKuOgHk");
        videoStatistics.setLikesCount(300000L);
        videoStatistics.setViewsCount(300000L);
        videoSnippet.setDescription("Some Description");
        videoSnippet.setTitle("Text video title");
        videoSnippet.setDefaultAudioLanguage("en");
        videoSnippet.setDefaultLanguage("ru");
        videoSnippet.setReleaseDate(new Date());
        videoSnippet.setRunTime(LocalTime.of(10, 55));
        videoSnippet.setRating(8.8);
        videoThumbnail.setUrl("http:simply.com");
        videoThumbnail.setHeight(30);
        videoThumbnail.setWidth(30);
        videoThumbnails.setDefaultThumbnail(videoThumbnail);
        videoThumbnails.setMaxresThumbnail(videoThumbnail);
        videoThumbnails.setHighThumbnail(videoThumbnail);
        videoThumbnails.setMediumThumbnail(videoThumbnail);
        videoThumbnails.setStandardThumbnail(videoThumbnail);

        video.setVideoStatistics(videoStatistics);
        video.setVideoSnippet(videoSnippet);
        video.setVideoThumbnails(videoThumbnails);

        VideoDTO videoDTO = videoMapper.toVideoDto(video);

        Assertions.assertNotNull(videoDTO, "not null");
        Assertions.assertNotNull(videoDTO.getUrl(),"not null");
        Assertions.assertNotNull(videoDTO.getVideoSnippetDTO(),"not null");
        Assertions.assertNotNull(videoDTO.getVideoStatisticsDTO(),"not null");
        Assertions.assertNotNull(videoDTO.getVideoThumbnailsDTO(),"not null");
        Assertions.assertNotNull(videoDTO.getVideoThumbnailsDTO().getDefaultThumbnail(),"not null");
        Assertions.assertNotNull(videoDTO.getVideoThumbnailsDTO().getHighThumbnail(),"not null");
        Assertions.assertNotNull(videoDTO.getVideoThumbnailsDTO().getMaxresThumbnail(),"not null");
        Assertions.assertNotNull(videoDTO.getVideoThumbnailsDTO().getMediumThumbnail(),"not null");
        Assertions.assertNotNull(videoDTO.getVideoThumbnailsDTO().getStandardThumbnail(),"not null");
    }

    @Test
    public void VideoDtoToEntity() {
        VideoDTO videoDTO = new VideoDTO();
        VideoSnippetDTO videoSnippetDTO = new VideoSnippetDTO();
        VideoStatisticsDTO videoStatisticsDTO = new VideoStatisticsDTO();
        VideoThumbnailsDTO videoThumbnailsDTO = new VideoThumbnailsDTO();
        VideoThumbnailDTO videoThumbnailDTO = new VideoThumbnailDTO();

        videoSnippetDTO.setDescription("TextDescription");
        videoSnippetDTO.setTitle("Title");
        videoSnippetDTO.setRating(8.8);
        videoSnippetDTO.setRunTime(LocalTime.of(20,34));
        videoSnippetDTO.setReleaseDate(new Date());
        videoSnippetDTO.setDefaultAudioLanguage("en");
        videoSnippetDTO.setDefaultLanguage("en");

        videoStatisticsDTO.setLikesCount(18888L);
        videoStatisticsDTO.setViewsCount(19999L);

        videoThumbnailDTO.setHeight(50);
        videoThumbnailDTO.setWidth(50);
        videoThumbnailDTO.setUrl("http:some.url");

        videoThumbnailsDTO.setDefaultThumbnail(videoThumbnailDTO);
        videoThumbnailsDTO.setStandardThumbnail(videoThumbnailDTO);
        videoThumbnailsDTO.setMediumThumbnail(videoThumbnailDTO);
        videoThumbnailsDTO.setMaxresThumbnail(videoThumbnailDTO);
        videoThumbnailsDTO.setHighThumbnail(videoThumbnailDTO);


        videoDTO.setVideoSnippetDTO(videoSnippetDTO);
        videoDTO.setVideoStatisticsDTO(videoStatisticsDTO);
        videoDTO.setVideoThumbnailsDTO(videoThumbnailsDTO);
        videoDTO.setUrl("SfqvJKuOgHk");

        Video video = videoMapper.toVideoEntity(videoDTO);

        Assertions.assertNotNull(video, "not null");
        Assertions.assertNotNull(video.getUrl(),"not null");
        Assertions.assertNotNull(video.getVideoSnippet(),"not null");
        Assertions.assertNotNull(video.getVideoStatistics(),"not null");
        Assertions.assertNotNull(video.getVideoThumbnails(),"not null");
        Assertions.assertNotNull(video.getVideoThumbnails().getDefaultThumbnail(),"not null");
        Assertions.assertNotNull(video.getVideoThumbnails().getHighThumbnail(),"not null");
        Assertions.assertNotNull(video.getVideoThumbnails().getMaxresThumbnail(),"not null");
        Assertions.assertNotNull(video.getVideoThumbnails().getMediumThumbnail(),"not null");
        Assertions.assertNotNull(video.getVideoThumbnails().getStandardThumbnail(),"not null");

    }

    @Test
    public void VideoDtoListToEntityList() {
        VideoDTO videoDTO = new VideoDTO();
        VideoSnippetDTO videoSnippetDTO = new VideoSnippetDTO();
        VideoStatisticsDTO videoStatisticsDTO = new VideoStatisticsDTO();
        VideoThumbnailsDTO videoThumbnailsDTO = new VideoThumbnailsDTO();
        VideoThumbnailDTO videoThumbnailDTO = new VideoThumbnailDTO();

        videoSnippetDTO.setDescription("TextDescription");
        videoSnippetDTO.setTitle("Title");
        videoSnippetDTO.setRating(8.8);
        videoSnippetDTO.setRunTime(LocalTime.of(20,34));
        videoSnippetDTO.setReleaseDate(new Date());
        videoSnippetDTO.setDefaultAudioLanguage("en");
        videoSnippetDTO.setDefaultLanguage("en");

        videoStatisticsDTO.setLikesCount(18888L);
        videoStatisticsDTO.setViewsCount(19999L);

        videoThumbnailDTO.setHeight(50);
        videoThumbnailDTO.setWidth(50);
        videoThumbnailDTO.setUrl("http:some.url");

        videoThumbnailsDTO.setDefaultThumbnail(videoThumbnailDTO);
        videoThumbnailsDTO.setStandardThumbnail(videoThumbnailDTO);
        videoThumbnailsDTO.setMediumThumbnail(videoThumbnailDTO);
        videoThumbnailsDTO.setMaxresThumbnail(videoThumbnailDTO);
        videoThumbnailsDTO.setHighThumbnail(videoThumbnailDTO);


        videoDTO.setVideoSnippetDTO(videoSnippetDTO);
        videoDTO.setVideoStatisticsDTO(videoStatisticsDTO);
        videoDTO.setVideoThumbnailsDTO(videoThumbnailsDTO);
        videoDTO.setUrl("SfqvJKuOgHk");

        List<VideoDTO> videoDTOList = new ArrayList<>();
        videoDTOList.add(videoDTO);
        videoDTOList.add(videoDTO);
        videoDTOList.add(videoDTO);

        List<Video> videos = videoMapper.toVideoEntityList(videoDTOList);
        Assertions.assertNotNull(videos, "not null");

        for (int i =0; i < videoDTOList.size(); i++) {
            Assertions.assertNotNull(videos.get(i), "not null");
            Assertions.assertNotNull(videos.get(i).getUrl(),"not null");
            Assertions.assertNotNull(videos.get(i).getVideoSnippet(),"not null");
            Assertions.assertNotNull(videos.get(i).getVideoStatistics(),"not null");
            Assertions.assertNotNull(videos.get(i).getVideoThumbnails(),"not null");
            Assertions.assertNotNull(videos.get(i).getVideoThumbnails().getDefaultThumbnail(),"not null");
            Assertions.assertNotNull(videos.get(i).getVideoThumbnails().getHighThumbnail(),"not null");
            Assertions.assertNotNull(videos.get(i).getVideoThumbnails().getMaxresThumbnail(),"not null");
            Assertions.assertNotNull(videos.get(i).getVideoThumbnails().getMediumThumbnail(),"not null");
            Assertions.assertNotNull(videos.get(i).getVideoThumbnails().getStandardThumbnail(),"not null");
        }
    }
    @Test
    public void VideoListToVideoDto() {
        Video video = new Video();
        VideoSnippet videoSnippet = new VideoSnippet();
        VideoStatistics videoStatistics = new VideoStatistics();
        VideoThumbnails videoThumbnails = new VideoThumbnails();
        VideoThumbnail videoThumbnail = new VideoThumbnail();
        video.setUrl("SfqvJKuOgHk");
        videoStatistics.setLikesCount(300000L);
        videoStatistics.setViewsCount(300000L);
        videoSnippet.setDescription("Some Description");
        videoSnippet.setTitle("Text video title");
        videoSnippet.setDefaultAudioLanguage("en");
        videoSnippet.setDefaultLanguage("ru");
        videoSnippet.setReleaseDate(new Date());
        videoSnippet.setRunTime(LocalTime.of(10, 55));
        videoSnippet.setRating(8.8);
        videoThumbnail.setUrl("http:simply.com");
        videoThumbnail.setHeight(30);
        videoThumbnail.setWidth(30);
        videoThumbnails.setDefaultThumbnail(videoThumbnail);
        videoThumbnails.setMaxresThumbnail(videoThumbnail);
        videoThumbnails.setHighThumbnail(videoThumbnail);
        videoThumbnails.setMediumThumbnail(videoThumbnail);
        videoThumbnails.setStandardThumbnail(videoThumbnail);

        video.setVideoStatistics(videoStatistics);
        video.setVideoSnippet(videoSnippet);
        video.setVideoThumbnails(videoThumbnails);

        List<Video> videos = new ArrayList<>();
        videos.add(video);
        videos.add(video);
        videos.add(video);
        List<VideoDTO> videoDTOList = videoMapper.toVideoDTOList(videos);
        for(int i = 0; i < videos.size(); i++) {
            Assertions.assertNotNull(videoDTOList.get(i), "not null");
            Assertions.assertNotNull(videoDTOList.get(i).getUrl(),"not null");
            Assertions.assertNotNull(videoDTOList.get(i).getVideoSnippetDTO(),"not null");
            Assertions.assertNotNull(videoDTOList.get(i).getVideoStatisticsDTO(),"not null");
            Assertions.assertNotNull(videoDTOList.get(i).getVideoThumbnailsDTO(),"not null");
            Assertions.assertNotNull(videoDTOList.get(i).getVideoThumbnailsDTO().getDefaultThumbnail(),"not null");
            Assertions.assertNotNull(videoDTOList.get(i).getVideoThumbnailsDTO().getHighThumbnail(),"not null");
            Assertions.assertNotNull(videoDTOList.get(i).getVideoThumbnailsDTO().getMaxresThumbnail(),"not null");
            Assertions.assertNotNull(videoDTOList.get(i).getVideoThumbnailsDTO().getMediumThumbnail(),"not null");
            Assertions.assertNotNull(videoDTOList.get(i).getVideoThumbnailsDTO().getStandardThumbnail(),"not null");
        }
    }
}
