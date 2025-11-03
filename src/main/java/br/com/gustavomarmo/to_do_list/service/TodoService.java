package br.com.gustavomarmo.to_do_list.service;

import br.com.gustavomarmo.to_do_list.model.Todo;
import br.com.gustavomarmo.to_do_list.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TodoService {
    private TodoRepository todoRepository;

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);
        return list();
    }
    public List<Todo> list() {
        return todoRepository.findAll();
    }
    public List<Todo> update(Todo todo) {
        todoRepository.save(todo);
        return list();
    }
    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }
}