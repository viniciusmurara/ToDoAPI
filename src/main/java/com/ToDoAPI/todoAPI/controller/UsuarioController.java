package com.ToDoAPI.todoAPI.controller;

import com.ToDoAPI.todoAPI.model.Usuario;
import com.ToDoAPI.todoAPI.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario) {

        usuario.setId_usuario(UUID.randomUUID());

        return usuarioRepository.save(usuario);
    }
}