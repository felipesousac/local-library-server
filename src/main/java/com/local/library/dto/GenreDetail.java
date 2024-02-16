package com.local.library.dto;

import com.local.library.model.Book;
import com.local.library.model.Genre;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class GenreDetail {

    private Long id;
    private String name;
    private List<Book> bookList;

    public GenreDetail(Genre genre, List<Book> books) {
        this.id = genre.getId();
        this.name = genre.getName();
        this.bookList = books;
    }
}
