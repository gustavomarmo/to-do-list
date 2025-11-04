package br.com.gustavomarmo.to_do_list.service;

import br.com.gustavomarmo.to_do_list.exception.TaskNotFoundException;
import br.com.gustavomarmo.to_do_list.model.Task;
import br.com.gustavomarmo.to_do_list.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> list() {
        return taskRepository.findAll();
    }

    public Task find(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException());
    }

    public List<Task> update(Long id, Task task) {
        Task taskExistente = taskRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com id: " + id));

        taskExistente.setNome(task.getNome());
        taskExistente.setDescricao(task.getDescricao());
        taskExistente.setRealizado(task.isRealizado());
        taskExistente.setPrioridade(task.getPrioridade());

        taskRepository.save(taskExistente);
        return list();
    }
    public List<Task> delete(Long id) {
        taskRepository.deleteById(id);
        return list();
    }
}