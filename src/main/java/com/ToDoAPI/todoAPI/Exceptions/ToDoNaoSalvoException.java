package com.ToDoAPI.todoAPI.Exceptions;

public class ToDoNaoSalvoException extends ToDoExceptions {
    public ToDoNaoSalvoException() {
        super("O To do enviado não esta salvo no banco de dados");
    }
}
