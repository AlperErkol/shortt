package com.example.shortt.url.application.dto.request;

import com.example.shortt.url.application.command.CreateUrl;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CreateUrlRequest {
    private String alias;
    @NotNull
    private String urlType;
    private String password;
    @NotNull
    private Boolean passwordProtection;
    private Boolean pinned;
    private LocalDateTime timeExpiration;

    public CreateUrl toModel() {
        return CreateUrl.builder()
                .alias(alias)
                .urlType(urlType)
                .password(password)
                .passwordProtection(passwordProtection)
                .timeExpiration(timeExpiration)
                .build();
    }
}
