package com.example.shortt.url.domain.exception;

public class UrlAlreadyExistException extends RuntimeException {
    private static final String ERROR_MESSAGE = "Url with the given alias already exists.";
    public UrlAlreadyExistException() {
        super(ERROR_MESSAGE);
    }
}
