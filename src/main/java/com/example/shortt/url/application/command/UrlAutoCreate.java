package com.example.shortt.url.application.command;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class UrlAutoCreate {
    private String uuid;
    private String originalUrl;
    private String urlType;
    private String password;
    private Boolean passwordProtection;
    private Date timeExpiration;


    public CreateUrl from(String alias) {
        return CreateUrl.builder()
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
