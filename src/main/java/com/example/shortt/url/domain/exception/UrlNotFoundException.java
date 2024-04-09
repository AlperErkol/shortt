package com.example.shortt.url.domain.exception;

public class UrlNotFoundException extends RuntimeException {
    private static final String ERROR_MESSAGE = "An url could not be found : ";
    public UrlNotFoundException(String message) {
        super(ERROR_MESSAGE + message);
    }
}
