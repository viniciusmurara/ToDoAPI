package com.ToDoAPI.todoAPI.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "todo")
@Data
public class ToDo {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String texto;

    @Column
    private String status;

    @JoinColumn
    @ManyToOne
    private Usuario usuario;


}
