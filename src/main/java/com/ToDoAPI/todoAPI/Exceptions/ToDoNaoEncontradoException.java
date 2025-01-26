package com.ToDoAPI.todoAPI.Exceptions;

public class ToDoNaoEncontradoException extends ToDoExceptions {
    public ToDoNaoEncontradoException() {
        super("Nenhum ToDo encontrado");
    }
}
