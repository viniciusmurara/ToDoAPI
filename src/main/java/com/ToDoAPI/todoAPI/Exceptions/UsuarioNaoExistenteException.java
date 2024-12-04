package com.ToDoAPI.todoAPI.Exceptions;

public class UsuarioNaoExistenteException extends RuntimeException {
    public UsuarioNaoExistenteException() {
        super("Nenhum usuário foi encontrado");
    }
}
