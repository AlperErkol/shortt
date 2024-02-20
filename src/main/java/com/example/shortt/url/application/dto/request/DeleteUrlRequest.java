package com.example.shortt.url.application.dto.request;

import com.example.shortt.url.application.command.DeleteUrl;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteUrlRequest {
    private String alias;

    public DeleteUrl toModel() {
        return DeleteUrl.builder().alias(alias).build();
    }
}
