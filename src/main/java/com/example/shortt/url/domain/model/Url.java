package com.example.shortt.url.domain.model;

import com.example.shortt.url.infra.common.AbstractModel;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Document(collection = "urls")
public class Url extends AbstractModel {
    @Field
    private String originalUrl;
    @Field
    private String alias;
    @Field
    private String urlType;
    @Field
    private String password;
    @Field
    private Boolean passwordProtection;
    @Field
    private Boolean pinned;
    @Field
    private LocalDateTime timeExpiration;
    @Field
    private Integer clickCount;

    public Url () {
        setOriginalUrl("shortt.app");
        setClickCount(0);
    }

    public static String generateAlias() {
        return "";
    }
}