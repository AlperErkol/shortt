package com.example.shortt.url.application.common;

import org.springframework.stereotype.Component;

public interface NoCommandHandler<R> {
    R handle();
}
