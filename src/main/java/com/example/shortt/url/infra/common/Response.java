package com.example.shortt.url.infra.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Response<T> {
    private boolean success;
    private String message;
    private T payload;
}
