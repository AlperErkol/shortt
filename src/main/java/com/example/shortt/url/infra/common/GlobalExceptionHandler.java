package com.example.shortt.url.infra.common;


import com.example.shortt.url.domain.exception.AuthenticationException;
import com.example.shortt.url.domain.exception.UrlAlreadyExistException;
import com.example.shortt.url.domain.exception.UrlNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> handleAuthenticationException(Exception ex) {
        Map<String, Object> body = generateBody(ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(UrlAlreadyExistException.class)
    public ResponseEntity<Object> handleUrlAlreadyExistException(Exception ex) {
        Map<String, Object> body = generateBody(ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<Object> handleUrlNotFoundException(Exception ex) {
        Map<String, Object> body = generateBody(ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    private Map<String, Object> generateBody(String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("result", false);
        body.put("message", message);
        return body;
    }
}
