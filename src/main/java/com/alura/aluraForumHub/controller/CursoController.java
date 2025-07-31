package com.alura.aluraForumHub.controller;

import com.alura.aluraForumHub.domain.Curso.Curso;
import com.alura.aluraForumHub.domain.repository.CursoRepository;
import com.alura.aluraForumHub.domain.Curso.DadosCurso;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-key")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<DadosCurso> buscarCurso(@PathVariable Long id) {
        return cursoRepository.findById(id)
                .map(curso -> ResponseEntity.ok(new DadosCurso(curso)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<DadosCurso>> listarCursos(@PageableDefault(sort = {"nome"}) Pageable pageable) {
        var pagina = cursoRepository.findAll(pageable).map(DadosCurso::new);
        return ResponseEntity.ok(pagina);
    }

    @PostMapping
    public ResponseEntity<DadosCurso> cadastrar(@RequestBody @Valid Curso curso) {
        var salvo = cursoRepository.save(curso);
        return ResponseEntity.ok(new DadosCurso(salvo));
    }

    @PutMapping
    public ResponseEntity<DadosCurso> editar(@RequestBody @Valid Curso curso) {
        var salvo = cursoRepository.save(curso);
        return ResponseEntity.ok(new DadosCurso(salvo));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        cursoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}



