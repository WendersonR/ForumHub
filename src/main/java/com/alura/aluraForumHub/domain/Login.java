package com.alura.aluraForumHub.domain;

import jakarta.validation.constraints.NotBlank;

public record Login(
        @NotBlank
        String login,
        @NotBlank
        String senha) {
}
