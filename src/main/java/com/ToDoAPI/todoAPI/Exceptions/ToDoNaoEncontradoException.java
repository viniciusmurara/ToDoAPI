package com.ToDoAPI.todoAPI.Exceptions;

public class ToDoNaoEncontradoException extends ToDoNaoSalvoException {
    public ToDoNaoEncontradoException() {
        super("Nenhum ToDo encontrado");
    }
}
