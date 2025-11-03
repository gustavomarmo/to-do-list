package br.com.gustavomarmo.to_do_list.controller;

import br.com.gustavomarmo.to_do_list.dto.TodoDTO;
import br.com.gustavomarmo.to_do_list.mapper.TodoMapper;
import br.com.gustavomarmo.to_do_list.model.Todo;
import br.com.gustavomarmo.to_do_list.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;
    private final TodoMapper todoMapper;

    public TodoController(TodoService todoService, TodoMapper todoMapper) {
        this.todoService = todoService;
        this.todoMapper = todoMapper;
    }

    @PostMapping
    List<TodoDTO> create(@RequestBody TodoDTO dto){
        Todo todo = todoMapper.ResponseEntity(dto);
        return todoMapper.ResponseDTOList((todoService.create(todo)));
    }

    @GetMapping
    List<TodoDTO> list() {
        TodoMapper mapper = new TodoMapper();

        return todoMapper.ResponseDTOList((todoService.list()));
    }

    @PutMapping
    List<TodoDTO> update(@RequestBody TodoDTO dto) {
        Todo todo = todoMapper.ResponseEntity(dto);

        return todoMapper.ResponseDTOList((todoService.update(todo)));
    }

    @DeleteMapping("/{id}")
    List<TodoDTO> delete(@PathVariable("id") Long id) {

        return todoMapper.ResponseDTOList(todoService.delete(id));
    }

}