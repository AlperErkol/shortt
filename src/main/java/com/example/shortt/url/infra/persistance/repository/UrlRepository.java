package com.example.shortt.url.infra.persistance.repository;

import com.example.shortt.url.domain.model.Url;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface UrlRepository extends MongoRepository<Url, Long> {
    Optional<Url> findByAlias(String alias);
    Optional<Url> deleteByAlias(String alias);
    List<Url> findByPinnedIsTrueAndUuidOrderByCreatedAtDesc(String uuid);
    List<Url> findByUuidOrderByCreatedAtDesc(String uuid);
}
