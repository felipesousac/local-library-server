package com.local.library.dto;

import com.local.library.model.Author;
import com.local.library.model.Book;
import com.local.library.model.BookInstance;
import com.local.library.model.Genre;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class BookDetail {

    private Long id;
    private String title;
    private Long authorId;
    private String authorFirstName;
    private String authorLastName;
    private String summary;
    private String isbn;
    private Long genreId;
    private String genreName;
    private List<BookInstance> bookInstances;


    public BookDetail(Book book, Author author, Genre genre, List<BookInstance> bookInstance) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.authorId = book.getAuthorid();
        this.authorFirstName = author.getFirstname();
        this.authorLastName = author.getLastname();
        this.summary = book.getSummary();
        this.isbn = book.getIsbn();
        this.genreId = book.getGenreid();
        this.genreName = genre.getName();
        this.bookInstances = bookInstance;
    }
}
