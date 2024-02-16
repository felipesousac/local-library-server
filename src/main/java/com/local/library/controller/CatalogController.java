package com.local.library.controller;

import com.local.library.domain.AuthorRepository;
import com.local.library.domain.BookInstanceRepository;
import com.local.library.domain.BookRepository;
import com.local.library.domain.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookInstanceRepository bookInstanceRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping
    public ResponseEntity<Map<String, Long>> counts() {
        HashMap<String, Long> map = new HashMap<>();
        map.put("book", bookRepository.count());
        map.put("author", authorRepository.count());
        map.put("bookInstance", bookInstanceRepository.count());
        map.put("bookInstanceAvailable", bookInstanceRepository.activeBookInstancesCount());
        map.put("genre", genreRepository.count());

        return ResponseEntity.ok(map);
    }
}
