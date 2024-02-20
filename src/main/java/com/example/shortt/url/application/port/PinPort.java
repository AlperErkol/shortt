package com.example.shortt.url.application.port;

import com.example.shortt.url.domain.model.Url;

public interface PinPort {
    Url create(Url url);
    Url retrieve(String alias);
}
