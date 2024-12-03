package com.ToDoAPI.todoAPI.controller.common;

import com.ToDoAPI.todoAPI.Exceptions.EmailJaUtilizadoException;
import com.ToDoAPI.todoAPI.controller.dto.ErroCampo;
import com.ToDoAPI.todoAPI.controller.dto.ErroResposta;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErroResposta handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<FieldError>fieldErros = ex.getFieldErrors();
        List<ErroCampo>  erroCampos =
                fieldErros.stream().map(fe -> new ErroCampo(fe.getField(), fe.getDefaultMessage())).toList();

        return new ErroResposta(HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage(), erroCampos);
    }

    @ExceptionHandler(EmailJaUtilizadoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErroResposta emailJaUtilizado(EmailJaUtilizadoException ex) {
        return ErroResposta.conflito(ex.getMessage());
    }

}
