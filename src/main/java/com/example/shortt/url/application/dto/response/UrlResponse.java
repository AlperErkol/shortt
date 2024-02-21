package com.example.shortt.url.application.dto.response;

import com.example.shortt.url.domain.model.Url;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UrlResponse {
    private String alias;
    private String urlType;
    private String password;
    private Boolean passwordProtection;
    private Boolean pinned;
    private LocalDateTime timeExpiration;
    private Integer clickCount;

    public static List<UrlResponse> fromListModel(List<Url> urlList) {
        return urlList.stream()
                .map(UrlResponse::fromModel)
                .toList();
    }

    public static UrlResponse fromModel(Url url) {
        return UrlResponse.builder()
                .alias(url.getAlias())
                .urlType(url.getUrlType())
                .password(url.getPassword())
                .passwordProtection(url.getPasswordProtection())
                .pinned(url.getPinned())
                .timeExpiration(url.getTimeExpiration())
                .clickCount(url.getClickCount())
                .build();
    }

}
