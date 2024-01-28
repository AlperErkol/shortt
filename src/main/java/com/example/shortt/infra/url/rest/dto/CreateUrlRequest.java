package com.example.shortt.infra.url.rest.dto;

import com.example.shortt.domain.url.model.Url;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUrlRequest {
    @Nonnull
    private BigInteger id;
    @Nullable
    private String alias;
    @Nonnull
    private String urlType;
    @Nullable
    private String password;
    @Nonnull
    private Boolean passwordProtection;
    @Nullable
    private Date timeExpiration;

    public Url toModel() {
        return Url.builder()
                .id(id)
                .alias(alias)
                .urlType(urlType)
                .password(password)
                .passwordProtection(passwordProtection)
                .timeExpiration(timeExpiration)
                .build();
    }
}
