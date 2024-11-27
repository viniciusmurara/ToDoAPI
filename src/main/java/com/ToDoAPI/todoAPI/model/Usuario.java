package com.ToDoAPI.todoAPI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table
@Getter
@Setter
public class Usuario {

    @Id
    @Column
    @NotBlank
    private UUID id_usuario;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String senha;

}
