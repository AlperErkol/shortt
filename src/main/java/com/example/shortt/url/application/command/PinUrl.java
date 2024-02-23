package com.example.shortt.url.application.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PinUrl {
    private String alias;

    public static PinUrl from(String alias) {
        return PinUrl.builder()
                .alias(alias)
                .build();
    }
}
