package com.example.shortt.url.application.common.commandhandler;

import com.example.shortt.url.application.command.DeleteUrlByAlias;
import com.example.shortt.url.application.common.CommandHandler;
import com.example.shortt.url.application.port.UrlPort;
import com.example.shortt.url.domain.model.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteUrlByAliasCommandHandler implements CommandHandler<Url, DeleteUrlByAlias> {
    private final UrlPort urlPort;

    @Override
    public Url handle(DeleteUrlByAlias command) {
        return urlPort.delete(command);
    }
}
