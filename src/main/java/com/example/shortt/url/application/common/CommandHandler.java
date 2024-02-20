package com.example.shortt.url.application.common;

public interface CommandHandler<R, T> {
    R handle(T command);
}
