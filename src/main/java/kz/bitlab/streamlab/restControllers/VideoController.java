package kz.bitlab.streamlab.restControllers;

import kz.bitlab.streamlab.dto.videos.VideoDTO;
import kz.bitlab.streamlab.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/videos")
@RequiredArgsConstructor
public class VideoController {
    private final VideoService videoService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(value = "/add-video/{videoId}")
    public void addVideoToDataBase(@PathVariable String videoId,
                                   @RequestParam(name = "runTime")
                                   @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX") LocalTime runTime,
                                   @RequestParam(name = "releaseDate")
                                       @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX") Date releaseDate,
                                   @RequestParam(name = "rating") double rating)
                                            throws GeneralSecurityException, IOException {
        videoService.addVideoToDataBase(videoId,runTime,releaseDate,rating);
    }

    @GetMapping(value = "/{id}")
    public VideoDTO getOneVideoByUrl(@PathVariable String id) {
        return videoService.getOneMovieFromDataBase(id);
    }

    @GetMapping(value = "/all")
    public List<VideoDTO> findAllVideos() {
        return videoService.getVideosFromDataBase();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping(value = "/update/{videoUrl}")
    public VideoDTO updateVideo(@PathVariable(name = "videoUrl") String videoUrl,
                                         @RequestParam Map<String ,Object> request) {
        return videoService.updateVideo(videoUrl, request);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteVideoFromDataBase(@RequestParam(name = "video_url") String videoUrl) {
        videoService.deleteVideoFromDataBase(videoUrl);
        return ResponseEntity.ok("Success");
    }


}
