package com.ToDoAPI.todoAPI.controller;

import com.ToDoAPI.todoAPI.model.Usuario;
import com.ToDoAPI.todoAPI.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final UsuarioService usuarioService;

    @GetMapping
    public Usuario login(@RequestParam("email") String email,
                                         @RequestParam("senha") String senha ) {

        return  usuarioService.findByEmailAndPassword(email, senha);

    }

}
