package com.ToDoAPI.todoAPI.service;


import com.ToDoAPI.todoAPI.model.Usuario;
import com.ToDoAPI.todoAPI.repository.UsuarioRepository;
import com.ToDoAPI.todoAPI.validator.UsuarioValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioValidator usuarioValidator;


    public Usuario salvar (Usuario usuario) {
//        UUID uuid = UUID.randomUUID();
//        usuario.setId(uuid);
       this.usuarioValidator.validar(usuario);
       return usuarioRepository.save(usuario);
    }
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
    public Usuario getOne(UUID id){
        return usuarioRepository.findById(id).orElse(null);
    }
    public void update(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
    public void delete(UUID id) {
        this.usuarioValidator.validar(usuarioRepository.findById(id).orElse(null));
        usuarioRepository.deleteById(id);
    }




}
