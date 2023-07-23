package kz.bitlab.streamlab.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VideosController {
    @GetMapping(value = "/videos")
    public String videosHome() {
        return "videos-home";
    }
    @GetMapping(value = "/videos/{videoId}/details")
    public String videoDetails(@PathVariable String videoId){
        return "video-details";
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/upload-video")
    public String uploadVideo() {
        return "add-video";
    }
}
