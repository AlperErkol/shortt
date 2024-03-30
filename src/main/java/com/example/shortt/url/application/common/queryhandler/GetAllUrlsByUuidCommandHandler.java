package com.example.shortt.url.application.common.queryhandler;

import com.example.shortt.url.application.common.CommandHandler;
import com.example.shortt.url.application.port.UrlPort;
import com.example.shortt.url.domain.model.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllUrlsByUuidCommandHandler implements CommandHandler<List<Url>, String> {
    private final UrlPort urlPort;

    @Override
    public List<Url> handle(String uuid) {
        return urlPort.retrieveAllByUuid(uuid);
    }
}
