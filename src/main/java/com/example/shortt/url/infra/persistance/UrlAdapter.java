package com.example.shortt.url.infra.persistance;

import com.example.shortt.url.application.port.UrlPort;
import com.example.shortt.url.domain.model.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UrlAdapter implements UrlPort {
    @Override
    public Url create(Url url) {
        return null;
    }

    @Override
    public Url retrieve(String alias) {
        return null;
    }

    @Override
    public List<Url> retrieveAll() {
        return null;
    }

    @Override
    public Url delete(String alias) {
        return null;
    }
}
