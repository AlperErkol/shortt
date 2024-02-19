package com.example.shortt.url.application.port;

import com.example.shortt.url.domain.model.Url;

public interface UrlPort {
    Url create();
    Url retrieve();
    Url update();
    Url delete();
}
