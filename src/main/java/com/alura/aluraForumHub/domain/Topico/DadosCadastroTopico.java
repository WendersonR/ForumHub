package com.alura.aluraForumHub.domain.Topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(
        @NotBlank String titulo,
        @NotBlank String mensagem,
        @NotNull StatusTopico status,
        @NotNull Long autorId,
        @NotNull Long cursoId
) {}


