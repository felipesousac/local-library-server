package com.local.library.service;


import com.local.library.domain.AuthorRepository;
import com.local.library.domain.BookRepository;
import com.local.library.dto.AuthorDetail;
import com.local.library.infra.exception.AuthorHasBooksException;
import com.local.library.model.Author;
import com.local.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
import java.util.List;


@Service
public class AuthorService {


    @Autowired
    private AuthorRepository authorRepository;


    @Autowired
    private BookRepository bookRepository;


    public ResponseEntity<AuthorDetail> authorDetailData(Long id) {
        Author author = authorRepository.getReferenceById(id);
        List<Book> books = bookRepository.findBooksByAuthorId(author.getId());

        return ResponseEntity.ok(new AuthorDetail(author, books));
    }


    public ResponseEntity createAuthor(Author data, UriComponentsBuilder uriBuilder) {
        Author author = new Author(data);
        authorRepository.save(author);

        URI uri = uriBuilder.path("/catalog/authors/detail/{id}").buildAndExpand(author.getId()).toUri();

        return ResponseEntity.created(uri).body(author);
    }


    public ResponseEntity deleteAuthorById(Long id) throws AuthorHasBooksException {
        List<Book> books = bookRepository.findAllByAuthorid(id);
        Author author = authorRepository.getReferenceById(id);

        if (!books.isEmpty()) {
            throw new AuthorHasBooksException("The author '" + author.getFirstname() + " " + author.getLastname() + "' has books in this library", author.getId());
        }

        authorRepository.delete(author);

        return ResponseEntity.noContent().build();
    }
}
