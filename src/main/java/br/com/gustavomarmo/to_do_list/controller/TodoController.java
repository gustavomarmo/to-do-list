package br.com.gustavomarmo.to_do_list.controller;

import br.com.gustavomarmo.to_do_list.model.Todo;
import br.com.gustavomarmo.to_do_list.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/todos") // Ele vai atender quando for colocada essa rota na URL
public class TodoController {
    private TodoService todoService;

    @PostMapping
    // @RequestBody indica que a pessoa deve passar o Todo no body do POST
    List<Todo> create(@RequestBody Todo todo){
        return todoService.create(todo);
    }

    // Especialização do endpoint
    @GetMapping
    List<Todo> list() {
        return todoService.list();
    }

    @PutMapping
    List<Todo> update(@RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("{id}") // A pessoa vai deletar colocando o parâmetro no caminho
    List<Todo> delete(@PathVariable("id") Long id) {
        return todoService.delete(id);
    }

}