package com.local.library.infra.exception;

import lombok.Getter;

@Getter
public class AuthorHasBooksException extends Exception {

    private final Long id;

    public AuthorHasBooksException(String errorMessage, Long id) {
        super(errorMessage);
        this.id = id;
    }
}
