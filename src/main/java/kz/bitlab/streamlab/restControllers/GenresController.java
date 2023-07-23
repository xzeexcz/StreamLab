package kz.bitlab.streamlab.restControllers;

import kz.bitlab.streamlab.dto.GenresDTO;
import kz.bitlab.streamlab.services.GenresService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenresController {
    private final GenresService genresService;

    @GetMapping
    public List<GenresDTO> findAllGenres() {
        return genresService.findAll();
    }
}
