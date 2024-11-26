package com.ToDoAPI.todoAPI.controller;

import com.ToDoAPI.todoAPI.model.Usuario;
import com.ToDoAPI.todoAPI.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @GetMapping("{nome}")
    public Usuario getOne(@PathVariable String nome){

        return this.usuarioRepository.findByNome(nome);
    }

    @PutMapping
    public Usuario update(@RequestBody Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    @DeleteMapping
    public void delete(@RequestBody Usuario usuario) {
        this.usuarioRepository.delete(usuario);
    }


}