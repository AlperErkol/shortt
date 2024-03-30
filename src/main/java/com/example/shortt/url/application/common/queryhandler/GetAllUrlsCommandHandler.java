package com.example.shortt.url.application.common.queryhandler;

import com.example.shortt.url.application.common.NoCommandHandler;
import com.example.shortt.url.application.port.UrlPort;
import com.example.shortt.url.domain.model.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllUrlsCommandHandler implements NoCommandHandler<List<Url>> {
    private final UrlPort urlPort;
    @Override
    public List<Url> handle() {
        return urlPort.retrieveAll();
    }
}
