package com.local.library.controller;

import com.local.library.domain.GenreRepository;
import com.local.library.dto.CreateGenreData;
import com.local.library.infra.exception.AlreadyCreatedException;
import com.local.library.model.Genre;
import com.local.library.service.GenreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/catalog/genres")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private GenreService genreService;

    @GetMapping
    private ResponseEntity<Page<Genre>> listGenresOrderByName(@PageableDefault(size = 15, sort = {"name"}) Pageable pagination) {
        return ResponseEntity.ok(genreRepository.findAll(pagination));
    }

    @GetMapping("/{id}")
    private ResponseEntity genreDetail(@PathVariable Long id) {
        return ResponseEntity.ok(genreService.genreDetail(id));
    }

    @GetMapping("/detail/{id}")
    private ResponseEntity<Optional<Genre>> genreName(@PathVariable Long id) {
        return ResponseEntity.ok(genreRepository.findById(id));
    }

    @PostMapping
    private ResponseEntity createGenre(@RequestBody @Valid CreateGenreData data, UriComponentsBuilder uriBuilder) throws AlreadyCreatedException {
        return genreService.createGenre(data, uriBuilder);
    }
}
