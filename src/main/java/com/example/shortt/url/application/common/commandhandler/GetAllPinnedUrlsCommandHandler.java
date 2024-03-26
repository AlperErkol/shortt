package com.example.shortt.url.application.common.commandhandler;

import com.example.shortt.url.application.common.CommandHandler;
import com.example.shortt.url.application.port.PinPort;
import com.example.shortt.url.domain.model.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllPinnedUrlsCommandHandler implements CommandHandler<List<Url>, String> {
    private final PinPort pinPort;

    @Override
    public List<Url> handle(String uuid) {
        return pinPort.retrieveAll(uuid);
    }
}
