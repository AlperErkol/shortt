package com.example.shortt.domain.url;

import com.example.shortt.domain.common.CommandHandler;
import com.example.shortt.domain.url.model.Url;

public class CreateAutoUrlCommandHandler implements CommandHandler<Url, Url> {

    // Ports

    @Override
    public Url handle(Url command) {
        var generatedAlias = "test";

    }
}
