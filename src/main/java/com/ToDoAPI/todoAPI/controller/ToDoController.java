package com.ToDoAPI.todoAPI.controller;

import com.ToDoAPI.todoAPI.controller.dto.ToDoRequest;
import com.ToDoAPI.todoAPI.model.ToDo;
import com.ToDoAPI.todoAPI.service.ToDoService;
import com.ToDoAPI.todoAPI.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoController implements GenericController{

    private final ToDoService service;
    private final UsuarioService usuarioService;

    @GetMapping("{id}")
    public ResponseEntity<ToDo> buscarPorId(@PathVariable Integer id) {

        this.service.getById(id);

        return ResponseEntity.ok().body(this.service.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<ToDo>> buscarTodos(){

        List<ToDo> toDos = this.service.pegarTodos();

        return ResponseEntity.ok().body(toDos);
    }


    @PostMapping
    public ResponseEntity<Void> salvarToDo(@RequestBody ToDoRequest toDoRequest){

        ToDo toDo = ToDoRequest.toToDo(toDoRequest);

        toDo.setUsuario(usuarioService.buscarPorId(toDoRequest.idUsuario()));

        service.salvar(toDo);

        URI location =  gerarHeaderLocation(toDo.getId());

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarToDo(@RequestBody ToDo toDo ){

        this.service.atualizar(toDo);

        return ResponseEntity.ok().build();

    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarToDo(@PathVariable Integer id){

        this.service.deletarPorId(id);

        return ResponseEntity.noContent().build();
    }


}
