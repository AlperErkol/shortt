package com.example.shortt.url.application.common.commandhandler;

import com.example.shortt.url.application.command.GetUrlByAlias;
import com.example.shortt.url.application.common.CommandHandler;
import com.example.shortt.url.application.port.UrlPort;
import com.example.shortt.url.domain.model.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetUrlByAliasCommandHandler implements CommandHandler<Url, GetUrlByAlias> {

    private final UrlPort urlPort;

    @Override
    public Url handle(GetUrlByAlias getUrlByAlias) {
        return urlPort.retrieve(getUrlByAlias);
    }
}
