package com.example.shortt.url.application.port;

import com.example.shortt.url.domain.model.Url;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UrlPort {
    Url create(Url url);
    Url retrieve(String alias);
    List<Url> retrieveAll();
    Url delete(String alias);
}
