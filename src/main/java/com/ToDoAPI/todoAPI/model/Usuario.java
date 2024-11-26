package com.ToDoAPI.todoAPI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table
public class Usuario {

    @Id
    @Column
    private UUID id_usuario;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String senha;

    public UUID getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(UUID id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
