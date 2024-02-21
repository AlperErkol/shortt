package com.example.shortt.url.application.common.commandhandler;

import com.example.shortt.url.application.command.CreateUrl;
import com.example.shortt.url.application.common.CommandHandler;
import com.example.shortt.url.application.port.UrlPort;
import com.example.shortt.url.domain.model.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUrlCommandHandler implements CommandHandler<Url, CreateUrl> {

    private final UrlPort urlPort;

    @Override
    public Url handle(CreateUrl command) {
        if (command.getUrlType().equalsIgnoreCase("auto"))
        {
            var urlAutoCreate = command.toUrlAutoCreate();
            return urlPort.createAutoUrl(urlAutoCreate);
        }
        else if (command.getUrlType().equalsIgnoreCase("custom"))
        {
            var urlCustomCreate = command.toUrlCustomCreate();
            return urlPort.createCustomUrl(urlCustomCreate);
        }

        throw new IllegalStateException("Invalid url type.");
    }
}
