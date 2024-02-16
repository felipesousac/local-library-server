package com.local.library.controller;

import com.local.library.domain.BookInstanceRepository;
import com.local.library.dto.BookInstanceDetail;
import com.local.library.model.BookInstance;
import com.local.library.service.BookInstanceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/catalog/bookinstances")
public class BookInstanceController {

    @Autowired
    private BookInstanceRepository bookInstanceRepository;

    @Autowired
    private BookInstanceService bookInstanceService;

    @GetMapping
    private ResponseEntity<Iterable<BookInstance>> bookInstancesList() {
        return ResponseEntity.ok(bookInstanceRepository.findBookinstanceWithBookNames());
    }

    @GetMapping("/{id}")
    private ResponseEntity<BookInstanceDetail> bookInstanceDetail(@PathVariable Long id) {
        return bookInstanceService.findBookInstanceWithBookName(id);
    }

    @GetMapping("/detail/{id}")
    private ResponseEntity bookName(@PathVariable Long id) {
        return ResponseEntity.ok(bookInstanceRepository.findById(id));
    }

    @PostMapping
    private ResponseEntity createBookInstance(@RequestBody @Valid BookInstance bookInstance, UriComponentsBuilder uriBuilder) {
        return bookInstanceService.createBookInstance(bookInstance, uriBuilder);
    }
}
