package com.local.library.service;

import com.local.library.domain.AuthorRepository;
import com.local.library.domain.BookInstanceRepository;
import com.local.library.domain.BookRepository;
import com.local.library.domain.GenreRepository;
import com.local.library.dto.BookDetail;
import com.local.library.dto.BookUpdateData;
import com.local.library.model.Author;
import com.local.library.model.Book;
import com.local.library.model.BookInstance;
import com.local.library.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private BookInstanceRepository bookInstanceRepository;

    public ResponseEntity<BookDetail> bookDetailData(Long id) {
        Book book = bookRepository.getReferenceById(id);
        Author author = authorRepository.getReferenceById(book.getAuthorid());
        Genre genre = genreRepository.getReferenceById(book.getGenreid());

        List<BookInstance> bookInstances = bookInstanceRepository.findAllByBookId(id);

        return ResponseEntity.ok(new BookDetail(book, author, genre, bookInstances));
    }

    public ResponseEntity createBook(Book data, UriComponentsBuilder uriBuilder) {
        Book book = new Book(data);
        bookRepository.save(book);

        URI uri = uriBuilder.path("/catalog/books/detail/{id}").buildAndExpand(book.getId()).toUri();

        return ResponseEntity.created(uri).body(book);
    }

    public ResponseEntity updateBook(BookUpdateData data, Long id) {
        Book book = bookRepository.getReferenceById(id);
        book.updateData(data);

        return ResponseEntity.ok(book);
    }
}
