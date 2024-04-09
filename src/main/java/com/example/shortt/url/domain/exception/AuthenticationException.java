package com.example.shortt.url.domain.exception;

public class AuthenticationException extends RuntimeException {
    private static final String ERROR_MESSAGE = "Authentication failed!";
    public AuthenticationException() {
        super(ERROR_MESSAGE);
    }
}
