package com.example.shortt.url.application.common;

public interface VoidCommandHandler<T> {
    void handle(T command);
}
