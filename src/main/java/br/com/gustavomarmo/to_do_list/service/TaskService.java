package br.com.gustavomarmo.to_do_list.service;

import br.com.gustavomarmo.to_do_list.exception.TaskNotFoundException;
import br.com.gustavomarmo.to_do_list.model.Task;
import br.com.gustavomarmo.to_do_list.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public Page<Task> list(int page, int itens) {
        return taskRepository.findAll(PageRequest.of(page, itens));
    }

    public Task find(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task update(Long id, Task task) {

        Task taskExistente = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));

        if (task.getNome() != null) {
            taskExistente.setNome(task.getNome());
        }
        if (task.getDescricao() != null) {
            taskExistente.setDescricao(task.getDescricao());
        }
        if (task.isRealizado() != null) {
            taskExistente.setRealizado(task.isRealizado());
        }
        if (task.getPrioridade() != null) {
            taskExistente.setPrioridade(task.getPrioridade());
        }

        taskRepository.save(taskExistente);

        return taskExistente;
    }
    public void delete(Long id) {
            taskRepository.deleteById(id);
    }
}