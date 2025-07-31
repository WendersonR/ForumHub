package com.alura.aluraForumHub.infra.exception;

import com.alura.aluraForumHub.domain.ValidacaoException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratamentoDeErros {

    public ResponseEntity<Void> tratarErro404(){
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<DadosErroValidacao>> tratarErro400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
    }

    public ResponseEntity<String> tratarErroRegrasDeNegocio(ValidacaoException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


    private record DadosErroValidacao(String campo, String mensagem){

        public DadosErroValidacao(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }

    }
}
