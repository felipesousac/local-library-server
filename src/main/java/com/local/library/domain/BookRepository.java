package com.local.library.domain;

import com.local.library.model.Book;
import com.local.library.model.BookInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b, a from Book b inner join Author a on (b.authorid = a.id)")
    Iterable<Book> findBookAndAuthorById();

    @Query("select a, b from Book a inner join Author b on (a.authorid = b.id) where (a.id = :id)")
    Iterable<Book> detailBookWithAuthorById(Long id);

    @Query("select a from Book a where a.authorid = :id")
    List<Book> findBooksByAuthorId(Long id);

    List<Book> findAllByAuthorid(Long id);
}
