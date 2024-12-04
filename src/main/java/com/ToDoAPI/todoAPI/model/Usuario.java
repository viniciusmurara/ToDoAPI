package com.ToDoAPI.todoAPI.model;

import jakarta.persistence.*;
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
    @Column(nullable = false, unique = true, length = 36)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false,length = 500)
    private String senha;

    @Column(nullable = false, length = 50)
    private String role;

}
