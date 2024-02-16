package com.local.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.local.library.dto.BookUpdateData;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "books")
@Entity(name = "Book")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotNull
    private Long authorid;

    @NotBlank
    private String summary;

    @NotBlank
    private String isbn;

    @NotNull
    private Long genreid;

    public Book(Book book) {
        this.title = book.getTitle().trim();
        this.authorid = book.getAuthorid();
        this.summary = book.getSummary().trim();
        this.isbn = book.getIsbn();
        this.genreid = book.getGenreid();
    }

    public void updateData(BookUpdateData data) {
        if (data.title() != null) {
            this.title = data.title();
        }

        if (data.summary() != null) {
            this.summary = data.summary();
        }

        if (data.isbn() != null) {
            this.isbn = data.isbn();
        }

        if (data.authorid() != null) {
            this.authorid = data.authorid();
        }

        if (data.genreid() != null) {
            this.genreid = data.genreid();
        }
    }
}
