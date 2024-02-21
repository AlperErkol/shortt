package com.example.shortt.url.application.command;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UrlAutoCreate {
    private String originalUrl;
    private String urlType;
    private String password;
    private Boolean passwordProtection;
    private LocalDateTime timeExpiration;


    public CreateUrl from(String alias) {
        return CreateUrl.builder()
                .originalUrl(originalUrl)
                .alias(alias)
                .urlType(urlType)
                .password(password)
                .passwordProtection(passwordProtection)
                .timeExpiration(timeExpiration)
                .build();
    }
}
