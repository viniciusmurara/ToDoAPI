package com.ToDoAPI.todoAPI.Exceptions;

public class ToDoJaSalvoException extends ToDoExceptions {
    public ToDoJaSalvoException() {
        super("O todo já foi salvo anteriormente");
    }
}
