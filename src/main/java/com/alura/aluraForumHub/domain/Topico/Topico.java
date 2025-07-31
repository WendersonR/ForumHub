package com.alura.aluraForumHub.domain.Topico;

import com.alura.aluraForumHub.domain.Curso.Curso;
import com.alura.aluraForumHub.domain.autor.Autor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private StatusTopico status;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    public Topico(String titulo, String mensagem, LocalDateTime dataCriacao, StatusTopico status, Autor autor, Curso curso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
    }

    public void atualizarDados(String titulo, String mensagem, StatusTopico status, Autor autor, Curso curso) {
        if (titulo != null) this.titulo = titulo;
        if (mensagem != null) this.mensagem = mensagem;
        if (status != null) this.status = status;
        if (autor != null) this.autor = autor;
        if (curso != null) this.curso = curso;
    }
}



