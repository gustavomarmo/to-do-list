package br.com.gustavomarmo.to_do_list.controller;

import br.com.gustavomarmo.to_do_list.dto.TaskDTO;
import br.com.gustavomarmo.to_do_list.dto.TaskUpdateDTO;
import br.com.gustavomarmo.to_do_list.mapper.TaskMapper;
import br.com.gustavomarmo.to_do_list.model.Task;
import br.com.gustavomarmo.to_do_list.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping
    List<TaskDTO> list() {
        return taskMapper.responseDTOList((taskService.list()));
    }

    @GetMapping("/{id}")
    TaskDTO find(@PathVariable Long id){
        return taskMapper.responseDTO(taskService.find(id));
    }

    @PostMapping
    Long create(@Valid @RequestBody TaskDTO dto){
        return taskMapper.responseDTO(taskService.create(taskMapper.responseEntity(dto))).getId();
    }

    @PutMapping("/{id}")
    List<TaskDTO> update(@PathVariable("id") Long id, @Valid @RequestBody TaskUpdateDTO updateDTO) {
        Task taskExistente = taskService.find(id);

        taskMapper.responseEntityUpdate(updateDTO, taskExistente);
        // Essa é a melhor maneira?
        taskService.create(taskExistente);

        return taskMapper.responseDTOList(taskService.list());
    }

    @DeleteMapping("/{id}")
    List<TaskDTO> delete(@PathVariable("id") Long id) {
        return taskMapper.responseDTOList(taskService.delete(id));
    }

}