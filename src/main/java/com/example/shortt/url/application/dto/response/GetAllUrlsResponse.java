package com.example.shortt.url.application.dto.response;

import com.example.shortt.url.application.query.GetAllUrls;
import com.example.shortt.url.domain.model.Url;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class GetAllUrlsResponse {
    private String alias;
    private String urlType;
    private String password;
    private Boolean passwordProtection;
    private Boolean pinned;
    private LocalDateTime timeExpiration;
    private Integer clickCount;

    public static List<GetAllUrls> fromModel(List<Url> urlList) {
        return urlList.stream()
                .map(url -> GetAllUrls.builder()
                        .alias(url.getAlias())
                        .urlType(url.getUrlType())
                        .password(url.getPassword())
                        .passwordProtection(url.getPasswordProtection())
                        .pinned(url.getPinned())
                        .timeExpiration(url.getTimeExpiration())
                        .clickCount(url.getClickCount())
                        .build())
                .toList();
    }

}
