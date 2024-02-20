package com.example.shortt.url.application.command;

import com.example.shortt.url.application.common.BaseCommand;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CreateShortUrl implements BaseCommand {
    private String alias;
    private String urlType;
    private String password;
    private Boolean passwordProtection;
    private Boolean pinned;
    private LocalDateTime timeExpiration;
}
