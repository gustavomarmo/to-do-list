package br.com.gustavomarmo.to_do_list.service;

import br.com.gustavomarmo.to_do_list.entity.Todo;
import br.com.gustavomarmo.to_do_list.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

// Aqui vão todas as operações que vamos fazer
@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo) {
        // Metodo do próprio JPA????
        todoRepository.save(todo);
        return list();
    }
    public List<Todo> list() {
        // Retorna todas as tarefas
        // E
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending()
        );
        return todoRepository.findAll(sort);
    }
    public List<Todo> update(Todo todo) {
        // Não entendi??
        todoRepository.save(todo);
        return list();
    }
    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }
}