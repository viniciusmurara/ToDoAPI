package com.ToDoAPI.todoAPI.service;


import com.ToDoAPI.todoAPI.model.Usuario;
import com.ToDoAPI.todoAPI.repository.UsuarioRepository;
import com.ToDoAPI.todoAPI.validator.UsuarioValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioValidator usuarioValidator;


    public Usuario salvar (Usuario usuario) {
       this.usuarioValidator.validar(usuario);
       return usuarioRepository.save(usuario);
    }
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }


    public Usuario buscarPorId(Integer id){
        return usuarioRepository.findById(id).orElse(null);
    }
    @Transactional
    public void update(Usuario usuario) {
        usuarioValidator.validar(usuario);
        usuarioRepository.save(usuario);
    }
    public void delete(Integer id) {
        this.usuarioValidator.validar(usuarioRepository.findById(id).orElse(null));
        usuarioRepository.deleteById(id);
    }
    public Usuario findByEmailAndPassword(String email, String senha) {
        return this.usuarioRepository.findByEmailAndSenha(email, senha).get();
    }




}
