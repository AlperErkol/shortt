package com.example.shortt.url.application.dto.request;

import com.example.shortt.url.application.command.CreateUrl;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class CreateUrlRequest {
    @NotNull
    private String uuid;
    @NotNull
    private String originalUrl;
    private String alias;
    @NotNull
    private String urlType;
    private String password;
    @NotNull
    private Boolean passwordProtection;
    private Date timeExpiration;

    public CreateUrl toModel() {
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
