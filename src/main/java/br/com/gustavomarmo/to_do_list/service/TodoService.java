package br.com.gustavomarmo.to_do_list.service;

import br.com.gustavomarmo.to_do_list.model.Todo;
import br.com.gustavomarmo.to_do_list.repository.TodoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }
    public List<Todo> list() {
        return todoRepository.findAll();
    }
    public Todo find(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com id: " + id));
    }

    public List<Todo> update(Long id, Todo todo) {
        Todo todoExistente = todoRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com id: " + id));

        todoExistente.setNome(todo.getNome());
        todoExistente.setDescricao(todo.getDescricao());
        todoExistente.setRealizado(todo.isRealizado());
        todoExistente.setPrioridade(todo.getPrioridade());

        todoRepository.save(todoExistente);
        return list();
    }
    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }
}