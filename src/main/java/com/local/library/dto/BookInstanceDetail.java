package com.local.library.dto;

import com.local.library.model.Book;
import com.local.library.model.BookInstance;
import com.local.library.model.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class BookInstanceDetail {

    private Long id;
    private Long bookId;
    private String bookTitle;
    private String imprint;
    private Status status;
    private LocalDate dueBack;

    public BookInstanceDetail(BookInstance bookInstance, Book book) {
        this.id = bookInstance.getId();
        this.bookId = bookInstance.getBookid();
        this.bookTitle = book.getTitle();
        this.imprint = bookInstance.getImprint();
        this.status = bookInstance.getStatus();
        this.dueBack = bookInstance.getDueback();
    }
}
