package com.ToDoAPI.todoAPI.controller.common;

import com.ToDoAPI.todoAPI.Exceptions.EmailJaUtilizadoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public void

    @ExceptionHandler(EmailJaUtilizadoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String emailJaUtilizado(EmailJaUtilizadoException ex) {
        return ex.getMessage();
    }

}
