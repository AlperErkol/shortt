package com.example.shortt.url.application.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CheckPassword {
    private String password;
    private String alias;
}
