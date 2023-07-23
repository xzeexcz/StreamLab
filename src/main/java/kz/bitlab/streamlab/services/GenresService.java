package kz.bitlab.streamlab.services;

import kz.bitlab.streamlab.dto.GenresDTO;

import java.util.List;

public interface GenresService {
    List<GenresDTO> findAll();
}
