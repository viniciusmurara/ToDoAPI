package com.ToDoAPI.todoAPI.service;

import com.ToDoAPI.todoAPI.Exceptions.ToDoJaSalvoException;
import com.ToDoAPI.todoAPI.Exceptions.ToDoNaoEncontradoException;
import com.ToDoAPI.todoAPI.Exceptions.ToDoNaoSalvoException;
import com.ToDoAPI.todoAPI.model.ToDo;
import com.ToDoAPI.todoAPI.repository.ToDoRepository;
import com.ToDoAPI.todoAPI.validator.ToDoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepository repository;
    private final ToDoValidator validator;

    public void salvar(ToDo toDo){
        validator.validarCadastro(toDo);
        repository.save(toDo);
    }
    public ToDo getById(Integer id){

        Optional<ToDo> toDo = this.repository.findById(id);
        if (toDo.isEmpty()){
            throw new ToDoNaoEncontradoException();
        }
        return this.repository.findById(id).get();
    }
    public void atualizar(ToDo toDo){
        this.validator.validadarUpdate(toDo);
        this.repository.save(toDo);

    }
    public void deletarPorId(Integer id){
        this.repository.deleteById(id);
    }
    public List<ToDo> buscarPorUsuario(Integer id){

        return this.repository.findAllByUsuarioId(id);
    }



}
