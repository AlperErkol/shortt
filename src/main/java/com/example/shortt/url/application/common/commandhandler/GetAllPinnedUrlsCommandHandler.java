package com.example.shortt.url.application.common.commandhandler;

import com.example.shortt.url.application.common.NoCommandHandler;
import com.example.shortt.url.application.port.PinPort;
import com.example.shortt.url.domain.model.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllPinnedUrlsCommandHandler implements NoCommandHandler<List<Url>> {
    private final PinPort pinPort;

    @Override
    public List<Url> handle() {
        return pinPort.retrieveAll();
    }
}
