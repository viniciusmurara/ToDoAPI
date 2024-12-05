package com.ToDoAPI.todoAPI.service;

import com.ToDoAPI.todoAPI.Exceptions.ToDoJaSalvoException;
import com.ToDoAPI.todoAPI.Exceptions.ToDoNaoSalvoException;
import com.ToDoAPI.todoAPI.Exceptions.UsuarioNaoExistenteException;
import com.ToDoAPI.todoAPI.model.ToDo;
import com.ToDoAPI.todoAPI.model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class ToDoServiceTest {

    @Autowired
    private ToDoService toDoService;

    @Autowired
    private UsuarioService usuarioService;


    @Test
    public void salvarTodoComIdTest(){

        ToDo toDo = new ToDo();

        toDo.setTexto("Testando");
        toDo.setUsuario(usuarioService.buscarPorId(1));
        toDo.setId(1);
        toDo.setTexto("testando");

        Assertions.assertThrows(ToDoJaSalvoException.class, () -> toDoService.salvar(toDo));
    }

    @Test
    public void salvarTodoComUsuarioInvalidoTest(){

        Usuario usuarioStub = new Usuario();
        usuarioStub.setId(1203112);

        ToDo toDo = new ToDo();

        toDo.setTexto("Testando");
        toDo.setUsuario(usuarioStub);
        toDo.setId(1);


        Assertions.assertThrows(UsuarioNaoExistenteException.class, () -> toDoService.salvar(toDo));
    }
    @Test
    public void atualizarTodoNaoSalvoTest(){

        ToDo toDo = new ToDo();

        toDo.setTexto("teste");
        toDo.setUsuario(usuarioService.buscarPorId(1));


        Assertions.assertThrows(ToDoNaoSalvoException.class, () -> toDoService.atualizar(toDo));
    }
    @Test
    public void atualizarTodoComUsuarioInvalidoTest(){


        Usuario usuarioStub = new Usuario();
        usuarioStub.setId(1203112);

        ToDo toDo = new ToDo();

        toDo.setTexto("Testando");
        toDo.setUsuario(usuarioStub);
        toDo.setId(1);


        Assertions.assertThrows(UsuarioNaoExistenteException.class, () -> toDoService.atualizar(toDo));

    }

}
