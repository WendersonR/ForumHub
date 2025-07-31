package com.alura.aluraForumHub.domain.repository;

import com.alura.aluraForumHub.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByLogin(String login);
}
