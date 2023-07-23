package kz.bitlab.streamlab.services.impls;

import kz.bitlab.streamlab.dto.GenresDTO;
import kz.bitlab.streamlab.mapper.GenresMapper;
import kz.bitlab.streamlab.respository.GenresRepository;
import kz.bitlab.streamlab.services.GenresService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenresServiceImpl implements GenresService {
    private final GenresRepository genresRepository;
    private final GenresMapper genresMapper;
    @Override
    public List<GenresDTO> findAll() {
        return genresMapper.toGenresDtoList(genresRepository.findAll());
    }
}
