package com.example.shortt.url.application.common.commandhandler;

import com.example.shortt.url.application.command.CheckPassword;
import com.example.shortt.url.application.common.CommandHandler;
import com.example.shortt.url.application.port.UrlPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckPasswordCommandHandler implements CommandHandler<Boolean, CheckPassword> {
    private final UrlPort urlPort;

    @Override
    public Boolean handle(CheckPassword command) {
        return urlPort.checkPassword(command);
    }
}
