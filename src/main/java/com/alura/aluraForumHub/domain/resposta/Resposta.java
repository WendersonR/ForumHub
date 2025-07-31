package com.alura.aluraForumHub.domain.resposta;

import com.alura.aluraForumHub.domain.Topico.Topico;
import com.alura.aluraForumHub.domain.autor.Autor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "resposta")
@Table(name = "respostas")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String solucao;

    @ManyToOne
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

}
