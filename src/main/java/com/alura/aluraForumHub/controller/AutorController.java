package com.alura.aluraForumHub.controller;

import com.alura.aluraForumHub.domain.autor.Autor;
import com.alura.aluraForumHub.domain.repository.AutorRepository;
import com.alura.aluraForumHub.domain.autor.DadosAutor;
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
@RequestMapping("/autores")
@SecurityRequirement(name = "bearer-key")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping("/{id}")
    public ResponseEntity<DadosAutor> buscarAutor(@PathVariable Long id){
        return autorRepository.findById(id)
                .map(autor -> ResponseEntity.ok(new DadosAutor(autor)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<DadosAutor>> listarAutores(@PageableDefault(sort = {"nome"}) Pageable pageable){
        var pagina = autorRepository.findAll(pageable).map(DadosAutor::new);
        return ResponseEntity.ok(pagina);
    }

    @PostMapping
    public ResponseEntity<DadosAutor> cadastrar(@RequestBody @Valid Autor a){
        var autorSalvo = autorRepository.save(a);
        return ResponseEntity.ok(new DadosAutor(autorSalvo));
    }

    @PutMapping
    public ResponseEntity<DadosAutor> editar(@RequestBody @Valid Autor a){
        var autorSalvo = autorRepository.save(a);
        return ResponseEntity.ok(new DadosAutor(autorSalvo));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> remover(@PathVariable Long id){
        autorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
