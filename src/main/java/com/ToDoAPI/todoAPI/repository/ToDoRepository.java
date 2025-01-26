package com.ToDoAPI.todoAPI.repository;

import com.ToDoAPI.todoAPI.controller.dto.ToDoResponse;
import com.ToDoAPI.todoAPI.model.ToDo;
import com.ToDoAPI.todoAPI.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Integer> {

    Optional<ToDo> findByTexto(String texto);

    List<ToDo> findAllByUsuarioId(Integer id);

}
