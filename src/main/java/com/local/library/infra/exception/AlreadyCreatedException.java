package com.local.library.infra.exception;

import lombok.Getter;

@Getter
public class AlreadyCreatedException extends Exception {

    private final Long genreId;

    public AlreadyCreatedException(String errorMessage, Long genreId) {
        super(errorMessage);
        this.genreId = genreId;
    }
}
