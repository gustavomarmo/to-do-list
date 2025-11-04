package br.com.gustavomarmo.to_do_list.controller;

import br.com.gustavomarmo.to_do_list.dto.TodoDTO;
import br.com.gustavomarmo.to_do_list.mapper.TodoMapper;
import br.com.gustavomarmo.to_do_list.service.TodoService;
import jakarta.validation.Valid;
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

    @GetMapping
    List<TodoDTO> list() {
        return todoMapper.responseDTOList((todoService.list()));
    }

    @GetMapping("/{id}")
    TodoDTO find(@PathVariable Long id){
        return todoMapper.responseDTO(todoService.find(id));
    }

    @PostMapping
    Long create(@Valid @RequestBody TodoDTO dto){
        return todoMapper.responseDTO(todoService.create(todoMapper.responseEntity(dto))).getId();
    }

    @PutMapping("/{id}")
    List<TodoDTO> update(@PathVariable("id") Long id, @Valid @RequestBody TodoDTO dto) {
        return todoMapper.responseDTOList((todoService.update(id,todoMapper.responseEntity(dto))));
    }

    @DeleteMapping("/{id}")
    List<TodoDTO> delete(@PathVariable("id") Long id) {
        return todoMapper.responseDTOList(todoService.delete(id));
    }

}