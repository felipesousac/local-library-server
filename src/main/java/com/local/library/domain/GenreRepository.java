package com.local.library.domain;

import com.local.library.model.Book;
import com.local.library.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query("select a from Book a where a.genreid = :id")
    List<Book> findBooksByGenreId(Long id);

    Genre findByName(String name);
}
