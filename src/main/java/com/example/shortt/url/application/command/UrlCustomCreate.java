package com.example.shortt.url.application.command;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UrlCustomCreate {
    private String originalUrl;
    private String alias;
    private String urlType;
    private String password;
    private Boolean passwordProtection;
    private LocalDateTime timeExpiration;

    public CreateUrl toModel() {
        return CreateUrl.builder()
                .originalUrl(getOriginalUrl())
                .alias(getAlias())
                .urlType(getUrlType())
                .password(getPassword())
                .passwordProtection(getPasswordProtection())
                .timeExpiration(getTimeExpiration())
                .build();
    }
}
