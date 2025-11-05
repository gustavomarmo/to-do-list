package br.com.gustavomarmo.to_do_list.controller;

import br.com.gustavomarmo.to_do_list.dto.TaskRequestDTO;
import br.com.gustavomarmo.to_do_list.dto.TaskRequestUpdateDTO;
import br.com.gustavomarmo.to_do_list.dto.TaskResponseIdDTO;
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
    List<TaskRequestDTO> list() {
        return taskMapper.responseDTOList((taskService.list()));
    }

    @GetMapping("/{id}")
    TaskRequestDTO find(@PathVariable Long id){
        return taskMapper.responseDTO(taskService.find(id));
    }

    @PostMapping
    TaskResponseIdDTO create(@Valid @RequestBody TaskRequestDTO dto){
        return taskMapper.responseIdDTO(taskService.create(taskMapper.responseEntity(dto)));
    }

    @PutMapping("/{id}")
    List<TaskRequestDTO> update(@PathVariable("id") Long id, @Valid @RequestBody TaskRequestUpdateDTO updateDTO) {
        Task task = taskMapper.responseEntityUpdate(updateDTO);
        return taskMapper.responseDTOList(taskService.update(id, task));
    }

    @DeleteMapping("/{id}")
    List<TaskRequestDTO> delete(@PathVariable("id") Long id) {
        return taskMapper.responseDTOList(taskService.delete(id));
    }

}