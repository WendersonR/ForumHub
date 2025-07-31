package com.alura.aluraForumHub.domain.Curso;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "curso")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String categoria;

    public Curso(DadosCurso dados) {
        this.nome = dados.nome();
        this.categoria = dados.categoria();
    }
}
