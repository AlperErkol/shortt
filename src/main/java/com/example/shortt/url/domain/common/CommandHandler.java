package com.example.shortt.url.domain.common;

public interface CommandHandler<E, T> {
    E handle(T command);
}
