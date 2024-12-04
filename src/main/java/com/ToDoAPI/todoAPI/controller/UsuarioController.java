package com.ToDoAPI.todoAPI.controller;

import com.ToDoAPI.todoAPI.controller.dto.UserDTO;
import com.ToDoAPI.todoAPI.model.Usuario;
import com.ToDoAPI.todoAPI.repository.UsuarioRepository;
import com.ToDoAPI.todoAPI.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.AbstractController;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class UsuarioController implements GenericController  {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody @Valid UserDTO usuarioDTO) {
        Usuario usuario = usuarioDTO.toUsuario();
        service.salvar(usuario);
        URI location = gerarHeaderLocation(usuario.getId());
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> getOne(@PathVariable Integer id){

        var usuario = this.service.getOne(id);
        return ResponseEntity.ok(usuario);

    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UserDTO usuarioDTO) {

        this.service.update(usuarioDTO.toUsuario());

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        this.service.delete(id);
    }
    @GetMapping("/login")
    public Usuario login(@RequestParam("email") String email,
                         @RequestParam("senha") String senha ) {

        return  service.findByEmailAndPassword(email, senha);

    }
}