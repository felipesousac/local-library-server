package com.local.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Table(name = "bookinstances")
@Entity(name = "Bookinstance")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class BookInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long bookid;

    @NotBlank
    private String imprint;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate dueback;

    public BookInstance(BookInstance data) {
        this.bookid = data.getBookid();
        this.imprint = data.getImprint();
        this.status = data.getStatus();

        if (data.getDueback() != null) {
            this.dueback = data.getDueback();
        }
    }
}
