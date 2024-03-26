package com.example.shortt.url.infra.persistance;

import com.example.shortt.url.application.command.PinUrl;
import com.example.shortt.url.application.port.PinPort;
import com.example.shortt.url.domain.model.Url;
import com.example.shortt.url.infra.persistance.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PinAdapter implements PinPort {
    private final UrlRepository urlRepository;

    @Override
    public List<Url> retrieveAll(String uuid) {
        return urlRepository.findByPinnedIsTrueAndUuidOrderByCreatedAtDesc(uuid);
    }

    @Override
    public Url update(PinUrl pinUrl) {
        Optional<Url> existingUrl = urlRepository.findByAlias(pinUrl.getAlias());
        if (existingUrl.isEmpty()) {
            throw new IllegalStateException("An url with specified alias could not be found.");
        }
        boolean currentPin = existingUrl.get().getPinned();
        existingUrl.get().setPinned(!currentPin);
        return urlRepository.save(existingUrl.get());
    }
}
