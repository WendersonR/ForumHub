package com.alura.aluraForumHub.domain.repository;

import com.alura.aluraForumHub.domain.autor.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
