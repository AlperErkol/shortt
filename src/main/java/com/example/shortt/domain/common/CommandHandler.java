package com.example.shortt.domain.common;

public interface CommandHandler<E, T> {
    E handle(T command);
}
