package com.alura.aluraForumHub.controller;

import com.alura.aluraForumHub.domain.Topico.DadosCadastroTopico;
import com.alura.aluraForumHub.domain.Topico.DadosDetalhamentoTopico;
import com.alura.aluraForumHub.domain.Topico.Topico;
import com.alura.aluraForumHub.domain.repository.AutorRepository;
import com.alura.aluraForumHub.domain.repository.CursoRepository;
import com.alura.aluraForumHub.domain.repository.TopicoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoTopico> cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {
        var autor = autorRepository.findById(dados.autorId())
                .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado"));
        var curso = cursoRepository.findById(dados.cursoId())
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));

        var topico = new Topico(
                dados.titulo(),
                dados.mensagem(),
                LocalDateTime.now(),
                dados.status(),
                autor,
                curso
        );

        topicoRepository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> buscarTopico(@PathVariable Long id) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tópico não encontrado"));
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoTopico>> listarTopicos(@PageableDefault(sort = {"titulo"}) Pageable pageable) {
        var pagina = topicoRepository.findAll(pageable).map(DadosDetalhamentoTopico::new);
        return ResponseEntity.ok(pagina);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoTopico> atualizarTopico(
            @PathVariable Long id,
            @RequestBody @Valid DadosCadastroTopico dados) {

        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tópico não encontrado"));

        var autor = autorRepository.findById(dados.autorId())
                .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado"));
        var curso = cursoRepository.findById(dados.cursoId())
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));

        topico.atualizarDados(
                dados.titulo(),
                dados.mensagem(),
                dados.status(),
                autor,
                curso
        );

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirTopico(@PathVariable Long id) {
        if (!topicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}





