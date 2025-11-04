package br.com.gustavomarmo.to_do_list.mapper;

import br.com.gustavomarmo.to_do_list.dto.TodoDTO;
import br.com.gustavomarmo.to_do_list.model.Todo;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TodoMapper {

    public Todo responseEntity(TodoDTO dto){
        Todo todo = new Todo();

        todo.setNome(dto.getNome());
        todo.setDescricao(dto.getDescricao());
        todo.setRealizado(dto.getRealizado());
        todo.setPrioridade(dto.getPrioridade());

        return todo;
    }

    public TodoDTO responseDTO(Todo todo){
        TodoDTO dto = new TodoDTO();

        dto.setId(todo.getId());
        dto.setNome(todo.getNome());
        dto.setDescricao(todo.getDescricao());
        dto.setRealizado(todo.isRealizado());
        dto.setPrioridade(todo.getPrioridade());

        return dto;
    }

    public List<TodoDTO> responseDTOList(List<Todo> todoList) {
        return todoList.stream()
                .map(this::responseDTO)
                .toList();
    }
}
