package com.ToDoAPI.todoAPI.validator;

import com.ToDoAPI.todoAPI.Exceptions.EmailJaUtilizadoException;
import com.ToDoAPI.todoAPI.model.Usuario;
import com.ToDoAPI.todoAPI.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioValidator {

    private final UsuarioRepository usuarioRepository;

    public void validar(Usuario usuario) {

        if(verificarSeExisteLogin(usuario.getEmail())){
            throw new EmailJaUtilizadoException();
        }

    }
    public boolean verificarSeExisteLogin(String login) {

        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(login);

        return optionalUsuario.isEmpty();


    }



}
