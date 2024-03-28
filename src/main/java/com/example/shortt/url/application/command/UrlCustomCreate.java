package com.example.shortt.url.application.command;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class UrlCustomCreate {
    private String uuid;
    private String originalUrl;
    private String alias;
    private String urlType;
    private String password;
    private Boolean passwordProtection;
    private Date timeExpiration;

    public CreateUrl toModel() {
        return CreateUrl.builder()
                .uuid(getUuid())
                .originalUrl(getOriginalUrl())
                .alias(getAlias())
                .urlType(getUrlType())
                .password(getPassword())
                .passwordProtection(getPasswordProtection())
                .timeExpiration(getTimeExpiration())
                .build();
    }
}
