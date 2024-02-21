package com.example.shortt.url.application.dto.request;

import com.example.shortt.url.application.command.DeleteUrlByAlias;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteUrlRequest {
    private String alias;

    public DeleteUrlByAlias toModel() {
        return DeleteUrlByAlias.builder().alias(alias).build();
    }
}
