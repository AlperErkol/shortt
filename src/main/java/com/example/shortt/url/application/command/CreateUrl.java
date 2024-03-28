package com.example.shortt.url.application.command;

import com.example.shortt.url.application.common.BaseCommand;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class CreateUrl implements BaseCommand {
    private String uuid;
    private String originalUrl;
    private String alias;
    private String urlType;
    private String password;
    private Boolean passwordProtection;
    private Date timeExpiration;

    public UrlAutoCreate toUrlAutoCreate() {
        return UrlAutoCreate.builder()
                .uuid(uuid)
                .originalUrl(originalUrl)
                .urlType(urlType)
                .password(password)
                .passwordProtection(passwordProtection)
                .timeExpiration(timeExpiration)
                .build();
    }

    public UrlCustomCreate toUrlCustomCreate() {
        return UrlCustomCreate.builder()
                .uuid(uuid)
                .originalUrl(originalUrl)
                .alias(alias)
                .urlType(urlType)
                .password(password)
                .passwordProtection(passwordProtection)
                .timeExpiration(timeExpiration)
                .build();
    }
}
