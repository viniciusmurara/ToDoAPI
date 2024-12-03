package com.ToDoAPI.todoAPI.controller.dto;

import com.ToDoAPI.todoAPI.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.NonNull;

import java.util.UUID;

public record UserDTO (
        Integer id,
        @NotBlank(message = "O nome é obrigatório")
                @Size(min = 4, message = "O nome deve conter no mínimo 4 caractéres")
        String nome,
        @NotBlank(message = "O email é obrigatório")
        @Email(message = "Email inválido")
        String email,
        @Size(min = 4, message = "A senha deve conter no mínimo 4 caractéres")
        String senha,
        @NotBlank(message = "A role é obrigatória")
        String role
)
    {

        public Usuario toUsuario() {
            Usuario usuario = new Usuario();
            usuario.setId(id);
            usuario.setEmail(email);
            usuario.setNome(nome);
            usuario.setSenha(senha);
            usuario.setRole(role);

            return usuario;
        }

}
