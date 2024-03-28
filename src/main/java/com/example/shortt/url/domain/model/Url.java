package com.example.shortt.url.domain.model;

import com.example.shortt.url.infra.common.AbstractModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "urls")
@AllArgsConstructor
@NoArgsConstructor
public class Url extends AbstractModel {
    @Field
    private String uuid;
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date timeExpiration;
    @Field
    private Integer clickCount = 0;
}