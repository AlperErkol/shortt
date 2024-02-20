package com.example.shortt.url.infra.persistance.repository;

import com.example.shortt.url.domain.model.Url;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface UrlRepository extends MongoRepository<Url, Long> {
    Url findByAlias(String alias);
    Url deleteByAlias(String alias);
    List<Url> findByOrderByCreatedAtDesc();
    List<Url> findByPinnedIsTrueOrderByCreatedAtDesc();
}
