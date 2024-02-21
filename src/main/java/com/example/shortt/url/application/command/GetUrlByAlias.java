package com.example.shortt.url.application.command;

import com.example.shortt.url.application.common.BaseCommand;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetUrlByAlias implements BaseCommand {
    private String alias;

    public static GetUrlByAlias from(String alias) {
        return GetUrlByAlias.builder().alias(alias).build();
    }
}
