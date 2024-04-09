package com.example.shortt.url.application.port;

import com.example.shortt.url.application.command.*;
import com.example.shortt.url.application.query.GetUrlByAlias;
import com.example.shortt.url.domain.model.Url;

import java.util.List;

public interface UrlPort {
    Url createAutoUrl(UrlAutoCreate urlAutoCreate);
    Url createCustomUrl(UrlCustomCreate urlCustomCreate);
    Url retrieve(GetUrlByAlias getUrlByAlias);
    List<Url> retrieveAll();
    List<Url> retrieveAllByUuid(String uuid);
    Url delete(DeleteUrlByAlias deleteUrlByAlias);
    Boolean checkPassword(CheckPassword checkPassword);
}
