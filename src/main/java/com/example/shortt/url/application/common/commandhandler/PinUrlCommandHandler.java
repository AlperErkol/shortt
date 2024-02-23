package com.example.shortt.url.application.common.commandhandler;

import com.example.shortt.url.application.command.PinUrl;
import com.example.shortt.url.application.common.CommandHandler;
import com.example.shortt.url.application.port.PinPort;
import com.example.shortt.url.domain.model.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PinUrlCommandHandler implements CommandHandler<Url, PinUrl> {
    private final PinPort pinPort;

    @Override
    public Url handle(PinUrl command) {
        return pinPort.update(command);
    }
}
