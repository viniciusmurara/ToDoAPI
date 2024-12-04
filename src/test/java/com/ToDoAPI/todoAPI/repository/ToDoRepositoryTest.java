package com.ToDoAPI.todoAPI.repository;

import com.ToDoAPI.todoAPI.model.StatusToDo;
import com.ToDoAPI.todoAPI.model.ToDo;
import com.ToDoAPI.todoAPI.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.glassfish.jaxb.core.v2.TODO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@SpringBootTest
public class ToDoRepositoryTest {

    @Autowired
    private ToDoRepository repository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    private Usuario usuario;

    @BeforeEach
    public  void setUp() {

        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail("teste@gmail.com");

        if(optionalUsuario.isPresent()){
            this.usuario = optionalUsuario.get();

        }
        else{
            this.usuario = new Usuario();
            usuario.setEmail("teste@gmail.com");
            usuario.setNome("UserTest");
            usuario.setRole("Operador");
            usuario.setSenha("123456");

            usuarioRepository.save(usuario);
            Assertions.assertTrue(usuarioRepository.findById(usuario.getId()).isPresent());
        }

    }

    @Test
    public void saveTodoTest(){

        Assertions.assertNotNull(usuario);

        ToDo toDo = new ToDo();

        toDo.setStatus(StatusToDo.A_FAZER);
        toDo.setTexto("Fazer café");
        toDo.setUsuario(usuario);

        repository.save(toDo);
    }
    @Test
    public void findTodoTest(){
        Assertions.assertNotNull(usuario);

        ToDo toDo = new ToDo();

        toDo.setStatus(StatusToDo.A_FAZER);
        toDo.setTexto("Fazer café");
        toDo.setUsuario(usuario);

        repository.save(toDo);


       Assertions.assertNotNull(repository.findById(toDo.getId()).orElse(null));
    }
    @Test
    public void atualizarTodoTest(){

        ToDo todo = repository.findById(1).orElse(null);

        Assertions.assertNotNull(todo);

        todo.setStatus(StatusToDo.CONCLUIDO);
        todo.setTexto("COlocar leite no café");

        repository.save(todo);

        Assertions.assertTrue(repository.findById(todo.getId()).get().getStatus() == StatusToDo.CONCLUIDO );
    }
    @Test
    public void deletarTodoTest(){

        repository.deleteById(1);
        Assertions.assertTrue(repository.findById(1).isEmpty());
    }

}
