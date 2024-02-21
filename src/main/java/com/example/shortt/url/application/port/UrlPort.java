package com.example.shortt.url.application.port;

import com.example.shortt.url.application.command.DeleteUrlByAlias;
import com.example.shortt.url.application.command.GetUrlByAlias;
import com.example.shortt.url.application.command.UrlAutoCreate;
import com.example.shortt.url.application.command.UrlCustomCreate;
import com.example.shortt.url.domain.model.Url;

import java.util.List;

public interface UrlPort {
    Url createAutoUrl(UrlAutoCreate urlAutoCreate);
    Url createCustomUrl(UrlCustomCreate urlCustomCreate);
    Url retrieve(GetUrlByAlias getUrlByAlias);
    List<Url> retrieveAll();
    Url delete(DeleteUrlByAlias deleteUrlByAlias);
}
