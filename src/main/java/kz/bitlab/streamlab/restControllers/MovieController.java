package kz.bitlab.streamlab.restControllers;

import kz.bitlab.streamlab.dto.MovieDTO;
import kz.bitlab.streamlab.services.MovieService;
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
@RequiredArgsConstructor
@RequestMapping(value = "/movie")
public class MovieController {

    private final MovieService movieService;
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(value = "/add-movie/{videoId}")
    public void addMovieToDataBase(@PathVariable String videoId,
                          @RequestParam(name = "genresId") List<Long> genresId,
                          @RequestParam(name = "runtime")
                              @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX") LocalTime runTime,
                          @RequestParam(name = "releaseDate")
                              @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX") Date releaseDate,
                          @RequestParam(name = "rating") double rating) throws GeneralSecurityException, IOException {
        movieService.addMovieToDataBase(videoId,genresId,runTime,releaseDate,rating);
    }
    @GetMapping(value = "/details/{videoId}")
    public MovieDTO getOneMovieDto(@PathVariable String videoId) {
    return movieService.getOneMovieDtoFromDataBase(videoId);
    }
    @GetMapping(value = "/all")
    public List<MovieDTO> getMoviesDtoFromDataBase() {
        return movieService.getMoviesDtoFromDataBase();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteMoviesFromDataBase(@RequestParam(name = "movie_url") String url) {
        movieService.deleteMoviesFromDataBase(url);

        return ResponseEntity.ok("Success");
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping(value = "/update/{movieId}")
    public MovieDTO updateMovie(@PathVariable("movieId") String movieId,
                                         @RequestParam Map<String, Object> request) {
        return movieService.updateMovie(movieId, request);
    }

}
