package com.ToDoAPI.todoAPI.service;

import com.ToDoAPI.todoAPI.Exceptions.ToDoNaoSalvoException;
import com.ToDoAPI.todoAPI.model.ToDo;
import com.ToDoAPI.todoAPI.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepository repository;

    public void salvar(ToDo toDo){
        this.repository.save(toDo);
    }
    public ToDo getById(Integer id){
        return this.repository.findById(id).get();
    }
    public void atualizar(ToDo toDo){

        if(toDo.getId() != null){
            this.repository.save(toDo);
            return;
        }
        throw new ToDoNaoSalvoException("O ToDo enviado não esta salvo no banco de dados");
    }
    public void deletarPorId(Integer id){
        this.repository.deleteById(id);
    }
    public List<ToDo> pegarTodos(){
        return this.repository.findAll();
    }



}
