package com.local.library.dto;

import com.local.library.model.Author;
import com.local.library.model.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
public class AuthorDetail {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Book> books;

    public AuthorDetail(Author author, List<Book> book) {
        this.id = author.getId();
        this.firstName = author.getFirstname();
        this.lastName = author.getLastname();
        this.birthDate = author.getBirthdate();
        this.deathDate = author.getDeathdate();
        this.books = book;
    }


}
