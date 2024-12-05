package com.ToDoAPI.todoAPI.validator;


import com.ToDoAPI.todoAPI.Exceptions.ToDoJaSalvoException;
import com.ToDoAPI.todoAPI.Exceptions.ToDoNaoSalvoException;
import com.ToDoAPI.todoAPI.Exceptions.UsuarioNaoExistenteException;
import com.ToDoAPI.todoAPI.model.ToDo;
import com.ToDoAPI.todoAPI.model.Usuario;
import com.ToDoAPI.todoAPI.repository.ToDoRepository;
import com.ToDoAPI.todoAPI.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ToDoValidator {

    private final UsuarioService usuarioService;
    private final ToDoRepository toDoRepository;


    public void validarCadastro(ToDo toDo){

        if(!verificaUsuarioValido(toDo)){
            throw new UsuarioNaoExistenteException();
        }
        if(verificaJaSalvo(toDo)){
            throw new ToDoJaSalvoException();
        }


    }
    public void validadarUpdate(ToDo toDo){

        if(!verificaJaSalvo(toDo)){
            throw new ToDoNaoSalvoException();
        }
        if(!verificaUsuarioValido(toDo)){
            throw new UsuarioNaoExistenteException();
        }

    }
    private boolean verificaJaSalvo(ToDo toDo){

        return toDo.getId() != null;

    }
    private boolean verificaUsuarioValido(ToDo toDo){

        Usuario usuario = usuarioService.buscarPorId(toDo.getUsuario().getId());

        return usuario != null;

    }




}
