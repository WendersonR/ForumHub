package com.alura.aluraForumHub.domain.Topico;

import com.alura.aluraForumHub.domain.Curso.DadosCurso;
import com.alura.aluraForumHub.domain.autor.DadosAutor;
import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        StatusTopico status,
        DadosAutor autor,
        DadosCurso curso
) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                new DadosAutor(topico.getAutor()),
                new DadosCurso(topico.getCurso())
        );
    }
}

