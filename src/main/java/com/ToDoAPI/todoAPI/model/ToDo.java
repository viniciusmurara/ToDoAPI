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

    @Column(length = 1000)
    private String texto;

    @Column(length = 30,nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusToDo status;

    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private Usuario usuario;


}
