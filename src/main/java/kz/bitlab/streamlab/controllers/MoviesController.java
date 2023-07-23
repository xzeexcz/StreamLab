package kz.bitlab.streamlab.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class MoviesController {
    @GetMapping("/")
    public String lamo() {
        return "movies-home";
    }
    @GetMapping(value = "/movies")
    public String movieHome() {
        return "movies-home";
    }
    @GetMapping(value = "/movies/{id}/details")
    public String movieDetails(@PathVariable String id) {
        return "movie-details";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/upload-movie")
    public String uploadMove() {
        return "add-movie";
    }
}
