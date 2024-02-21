package com.example.shortt.url.domain.model;

import com.example.shortt.url.infra.common.AbstractModel;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "urls")
@AllArgsConstructor
@NoArgsConstructor
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
    private Boolean pinned = false;
    @Field
    private LocalDateTime timeExpiration;
    @Field
    private Integer clickCount = 0;
}