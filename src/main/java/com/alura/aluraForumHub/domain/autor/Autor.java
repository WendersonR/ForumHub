package com.alura.aluraForumHub.domain.autor;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "autores")
@Entity(name = "Autor")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    public Autor(DadosAutor dados) {
        this.nome = dados.nome();
        this.email = dados.email();
    }
}
