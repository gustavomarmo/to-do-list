package br.com.gustavomarmo.to_do_list.mapper;

import br.com.gustavomarmo.to_do_list.dto.TodoDTO;
import br.com.gustavomarmo.to_do_list.dto.TodoUpdateDTO;
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

    public void responseEntityUpdate(TodoUpdateDTO dto, Todo todo){
        if (dto.getNome() != null) {
            todo.setNome(dto.getNome());
        }
        if (dto.getDescricao() != null) {
            todo.setDescricao(dto.getDescricao());
        }
        if (dto.getRealizado() != null) {
            todo.setRealizado(dto.getRealizado());
        }
        if (dto.getPrioridade() != null) {
            todo.setPrioridade(dto.getPrioridade());
        }
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
