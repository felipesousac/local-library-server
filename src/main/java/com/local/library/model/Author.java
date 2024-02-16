package com.local.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "authors")
@Entity(name = "Author")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String firstname;

    @NotBlank
    @Size(max = 100)
    private String lastname;

    private LocalDate birthdate;

    private LocalDate deathdate;

    public Author(Author data) {
        this.firstname = data.getFirstname().trim();
        this.lastname = data.getLastname().trim();
        this.birthdate = data.getBirthdate();

        if (data.getDeathdate() != null) {
            this.deathdate = data.getDeathdate();
        }
    }
}
