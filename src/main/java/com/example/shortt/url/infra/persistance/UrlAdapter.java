package com.example.shortt.url.infra.persistance;

import com.example.shortt.url.application.command.*;
import com.example.shortt.url.application.port.UrlPort;
import com.example.shortt.url.domain.model.Url;
import com.example.shortt.url.infra.persistance.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;
import static com.example.shortt.url.domain.util.AliasGenerator.generateAlias;

@Slf4j
@Service
@RequiredArgsConstructor
public class UrlAdapter implements UrlPort {

    private final UrlRepository urlRepository;

    @Override
    public Url createCustomUrl(UrlCustomCreate urlCustomCreate) {
        if (isAliasExist(urlCustomCreate.getAlias())) {
            throw new IllegalArgumentException("A URL with the given alias already exists.");
        }
        var createUrl = urlCustomCreate.toModel();
        return create(createUrl);
    }

    @Override
    public Url createAutoUrl(UrlAutoCreate urlAutoCreate) {
        String alias = "";
        do {
            alias = generateAlias();
        } while (isAliasExist(alias));

        var createUrl = urlAutoCreate.from(alias);
        return create(createUrl);
    }

    @Override
    public Url retrieve(GetUrlByAlias getUrlByAlias) {
        String alias = getUrlByAlias.getAlias();
        return urlRepository.findByAlias(alias).orElseThrow(() -> new NotFoundException("An url with alias " + alias + " could not be found."));
    }

    @Override
    public List<Url> retrieveAll() {
        return urlRepository.findAll();
    }

    @Override
    public List<Url> retrieveAllByUuid(String uuid) {
        return urlRepository.findAllByUuid(uuid);
    }

    @Override
    public Url delete(DeleteUrlByAlias deleteUrlByAlias) {
        String alias = deleteUrlByAlias.getAlias();
        return urlRepository.deleteByAlias(alias).orElseThrow(() -> new NotFoundException("An url with alias " + alias + " could not be found."));
    }

    private boolean isAliasExist(String alias) {
        Optional<Url> existingUrl = urlRepository.findByAlias(alias);
        return existingUrl.isPresent();
    }

    private Url create(CreateUrl createUrl) {
        var url = new Url();
        url.setUuid(createUrl.getUuid());
        url.setOriginalUrl(createUrl.getOriginalUrl());
        url.setAlias(createUrl.getAlias());
        url.setUrlType(createUrl.getUrlType());
        url.setPassword(createUrl.getPassword());
        url.setPasswordProtection(createUrl.getPasswordProtection());
        url.setTimeExpiration(createUrl.getTimeExpiration());
        return urlRepository.save(url);
    }
}
