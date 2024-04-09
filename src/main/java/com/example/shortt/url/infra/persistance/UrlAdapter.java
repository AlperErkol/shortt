package com.example.shortt.url.infra.persistance;

import com.example.shortt.url.application.command.*;
import com.example.shortt.url.application.port.UrlPort;
import com.example.shortt.url.application.query.GetUrlByAlias;
import com.example.shortt.url.domain.exception.AuthenticationException;
import com.example.shortt.url.domain.exception.UrlAlreadyExistException;
import com.example.shortt.url.domain.exception.UrlNotFoundException;
import com.example.shortt.url.domain.model.Url;
import com.example.shortt.url.infra.persistance.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import static com.example.shortt.url.domain.util.AliasGenerator.generateAlias;

@Slf4j
@Service
@RequiredArgsConstructor
public class UrlAdapter implements UrlPort {

    private final UrlRepository urlRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Url createCustomUrl(UrlCustomCreate urlCustomCreate) {
        if (isAliasExist(urlCustomCreate.getAlias())) {
            throw new UrlAlreadyExistException();
        }
        var createUrl = urlCustomCreate.toModel();
        return create(createUrl);
    }

    @Override
    public Url createAutoUrl(UrlAutoCreate urlAutoCreate) {
        String alias;
        do {
            alias = generateAlias();
        } while (isAliasExist(alias));

        var createUrl = urlAutoCreate.from(alias);
        return create(createUrl);
    }

    @Override
    public Url retrieve(GetUrlByAlias getUrlByAlias) {
        String alias = getUrlByAlias.getAlias();
        return urlRepository.findByAlias(alias).orElseThrow(() -> new UrlNotFoundException(alias));
    }

    @Override
    public List<Url> retrieveAll() {
        return urlRepository.findAll();
    }

    @Override
    public List<Url> retrieveAllByUuid(String uuid) {
        return urlRepository.findByUuidOrderByCreatedAtDesc(uuid);
    }

    @Override
    public Url delete(DeleteUrlByAlias deleteUrlByAlias) {
        String alias = deleteUrlByAlias.getAlias();
        return urlRepository.deleteByAlias(alias).orElseThrow(() -> new UrlNotFoundException(alias));
    }

    private boolean isAliasExist(String alias) {
        Optional<Url> existingUrl = urlRepository.findByAlias(alias);
        return existingUrl.isPresent();
    }

    private Url getAlias(String alias) {
        return urlRepository.findByAlias(alias).orElseThrow(() -> new UrlNotFoundException(alias));
    }

    private Url create(CreateUrl createUrl) {
        var url = new Url();
        url.setUuid(createUrl.getUuid());
        url.setOriginalUrl(createUrl.getOriginalUrl());
        url.setAlias(createUrl.getAlias());
        url.setUrlType(createUrl.getUrlType());
        String encryptedPassword = encryptPassword(createUrl);
        url.setPassword(encryptedPassword);
        url.setPasswordProtection(createUrl.getPasswordProtection());
        url.setTimeExpiration(createUrl.getTimeExpiration());
        return urlRepository.save(url);
    }

    private String encryptPassword(CreateUrl url) {
        if (Boolean.FALSE.equals(url.getPasswordProtection()) || Boolean.TRUE.equals(url.getPassword().equals("")) || url.getPassword() == null) return null;
        String password = url.getPassword();
        return passwordEncoder.encode(password);
    }

    @Override
    public Boolean checkPassword(CheckPassword checkPassword) {
        var alias = checkPassword.getAlias();
        Url url = getAlias(alias);
        var plainPassword = checkPassword.getPassword();
        boolean matches = passwordEncoder.matches(plainPassword, url.getPassword());
        if (!matches) {
            throw new AuthenticationException();
        }
        return true;
    }
}
