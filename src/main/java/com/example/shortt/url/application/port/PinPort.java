package com.example.shortt.url.application.port;

import com.example.shortt.url.application.command.PinUrl;
import com.example.shortt.url.domain.model.Url;
import java.util.List;

public interface PinPort {
    Url update(PinUrl pinUrl);
    List<Url> retrieveAll(String uuid);
}
