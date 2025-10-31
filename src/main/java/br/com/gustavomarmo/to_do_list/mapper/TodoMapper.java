package br.com.gustavomarmo.to_do_list.mapper;

import br.com.gustavomarmo.to_do_list.dto.TodoDTO;
import br.com.gustavomarmo.to_do_list.model.Todo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component // Permite o Spring identificar a classe e permite injetá-la
public class TodoMapper {

    public Todo toEntity(TodoDTO dto){
        Todo todo = new Todo();

        // Não preciso setar o ID aqui porque quando instancio o objeto todo, ele já cria um ID automático
        todo.setNome(dto.getNome());
        todo.setDescricao(dto.getDescricao());
        todo.setRealizado(dto.isRealizado());
        todo.setPrioridade(dto.getPrioridade());

        return todo;
    }

    public TodoDTO toResponseDTO(Todo todo){
        TodoDTO dto = new TodoDTO();

        dto.setNome(todo.getNome());
        dto.setDescricao(todo.getDescricao());
        dto.setRealizado(todo.isRealizado());
        dto.setPrioridade(todo.getPrioridade());

        return dto;
    }

    public List<TodoDTO> toResponseDTOList(List<Todo> todoList) {
        return todoList.stream()
                .map(this::toResponseDTO) // Converte cada Todo para TodoDTO
                .collect(Collectors.toList());  // Coleta o resultado em uma nova lista
    }
}
