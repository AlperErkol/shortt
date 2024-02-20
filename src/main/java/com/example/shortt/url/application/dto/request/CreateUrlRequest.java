package com.example.shortt.url.application.dto.request;

import com.example.shortt.url.application.command.CreateShortUrl;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CreateUrlRequest {
    private String alias;
    private String urlType;
    private String password;
    private Boolean passwordProtection;
    private Boolean pinned;
    private LocalDateTime timeExpiration;

    public CreateShortUrl toModel() {
        return CreateShortUrl.builder()
                .alias(alias)
                .urlType(urlType)
                .password(password)
                .passwordProtection(passwordProtection)
                .pinned(pinned)
                .timeExpiration(timeExpiration)
                .build();
    }
}
