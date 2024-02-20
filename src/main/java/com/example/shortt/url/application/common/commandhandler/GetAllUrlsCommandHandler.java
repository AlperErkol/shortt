package com.example.shortt.url.application.common.commandhandler;

import com.example.shortt.url.application.common.NoCommandHandler;
import com.example.shortt.url.application.port.UrlPort;
import com.example.shortt.url.domain.model.Url;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class GetAllUrlsCommandHandler implements NoCommandHandler<List<Url>> {
    private final UrlPort urlPort;
    @Override
    public List<Url> handle() {
        log.info("Im here..");
        return urlPort.retrieveAll();
    }
}
