package com.ToDoAPI.todoAPI.Exceptions;

public class ToDoNaoSalvoException extends RuntimeException {
    public ToDoNaoSalvoException(String message) {
        super(message);
    }
}
