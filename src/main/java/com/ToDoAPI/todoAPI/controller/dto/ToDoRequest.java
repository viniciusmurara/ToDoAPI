package com.ToDoAPI.todoAPI.controller.dto;

import com.ToDoAPI.todoAPI.model.StatusToDo;
import com.ToDoAPI.todoAPI.model.ToDo;

public record ToDoRequest(
        String texto,
        StatusToDo status,
        Integer idUsuario
        ) {

    public static ToDo toToDo(ToDoRequest toDoRequest){
        ToDo toDo = new ToDo();

        toDo.setTexto(toDoRequest.texto);
        toDo.setStatus(toDoRequest.status);

        return toDo;
    }
}
