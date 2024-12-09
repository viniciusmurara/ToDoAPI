package com.ToDoAPI.todoAPI.controller.dto;

import java.util.ArrayList;
import java.util.List;
import com.ToDoAPI.todoAPI.model.StatusToDo;
import com.ToDoAPI.todoAPI.model.ToDo;

public record ToDoResponse(Integer id,
                           String text,
                           StatusToDo status) {

    public static List<ToDoResponse> toToDoResponse(List<ToDo> toDos){
        return toDos.stream().map(ToDoResponse::toToDoResponse).toList();
    }
    public static ToDoResponse toToDoResponse(ToDo toDo){
        return new ToDoResponse(toDo.getId(), toDo.getTexto(),toDo.getStatus());
    }

}
