package com.ToDoAPI.todoAPI.repository;

import com.ToDoAPI.todoAPI.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Integer> {

    Optional<ToDo> findByTexto(String texto);

}
