package com.example.shortt.domain.url.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
@Document(collection = "urls")
public class Url {
    @Id
    private BigInteger id;
    private String uuid;
    private String originalUrl;
    private String alias;
    private String urlType;
    private String password;
    private Boolean passwordProtection;
    private Boolean pinned;
    private Date timeExpiration;
    @CreatedDate
    private Date creationDate;
    private int clickCount;

    public Url () {
        this.clickCount = 0;
        this.pinned = false;
    }
}