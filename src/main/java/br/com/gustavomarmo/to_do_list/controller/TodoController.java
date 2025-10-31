package br.com.gustavomarmo.to_do_list.controller;

import br.com.gustavomarmo.to_do_list.dto.TodoDTO;
import br.com.gustavomarmo.to_do_list.mapper.TodoMapper;
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
    private TodoMapper todoMapper;

    @PostMapping
    // @RequestBody indica que a pessoa deve passar o Todo no body do POST
    List<TodoDTO> create(@RequestBody TodoDTO dto){
        // 2) Aqui a Controller vai chamar o Mapper usando o DTO que ela recebeu, e vai instanciar um todo
        Todo todo = todoMapper.toEntity(dto);

        // 3) Aqui a Controller chama o Service porque ela já tem o model em mãos
        return todoMapper.toResponseDTOList((todoService.create(todo)));
    }

    // Especialização do endpoint, AINDA NECESSÁRIO FAZER
    @GetMapping
    List<TodoDTO> list() {
        TodoMapper mapper = new TodoMapper();

        return todoMapper.toResponseDTOList((todoService.list()));
    }

    @PutMapping
    List<TodoDTO> update(@RequestBody TodoDTO dto) {
        Todo todo = todoMapper.toEntity(dto);

        return todoMapper.toResponseDTOList((todoService.update(todo)));
    }

    @DeleteMapping("{id}") // A pessoa vai deletar colocando o parâmetro no caminho
    List<TodoDTO> delete(@PathVariable("id") Long id) {

        return todoMapper.toResponseDTOList(todoService.delete(id));
    }

}