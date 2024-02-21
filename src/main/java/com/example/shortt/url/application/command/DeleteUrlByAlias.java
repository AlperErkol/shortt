package com.example.shortt.url.application.command;

import com.example.shortt.url.application.common.BaseCommand;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteUrlByAlias implements BaseCommand {
    private String alias;

    public static DeleteUrlByAlias from(String alias) {
        return DeleteUrlByAlias.builder().alias(alias).build();
    }

}
