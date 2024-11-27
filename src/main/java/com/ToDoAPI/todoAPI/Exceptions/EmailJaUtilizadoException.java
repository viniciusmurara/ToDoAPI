package com.ToDoAPI.todoAPI.Exceptions;

public class EmailJaUtilizadoException extends RuntimeException {
    public EmailJaUtilizadoException() {
        super("Este email já esta sendo utilizado");
    }
}
