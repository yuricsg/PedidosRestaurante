package io.github.yuricsg.pedidosapi.controller.common;

import io.github.yuricsg.pedidosapi.dto.ErroCampo;
import io.github.yuricsg.pedidosapi.dto.ErroResposta;
import io.github.yuricsg.pedidosapi.exceptions.RegistroDuplicadoException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErroResposta handleHethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<FieldError> fieldErrors = e.getFieldErrors();
        List<ErroCampo> listaErros = fieldErrors
                .stream()
                .map(fe -> new ErroCampo(fe.getField(), fe.getDefaultMessage()))
                .collect(Collectors.toList());
        return new ErroResposta(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Erro de validação",
                listaErros);
    }

    @ExceptionHandler(RegistroDuplicadoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErroResposta handleRegistroDuplicadoException(RegistroDuplicadoException e){
        return ErroResposta.conflito(e.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErroResposta handleAcessDeniedException(AccessDeniedException e){
        return new ErroResposta(HttpStatus.FORBIDDEN.value(), "Acesso negado", List.of());
    }
}
