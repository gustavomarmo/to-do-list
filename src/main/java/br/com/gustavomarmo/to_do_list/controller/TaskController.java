package br.com.gustavomarmo.to_do_list.controller;

import br.com.gustavomarmo.to_do_list.dto.TaskRequestDTO;
import br.com.gustavomarmo.to_do_list.dto.TaskRequestUpdateDTO;
import br.com.gustavomarmo.to_do_list.dto.TaskResponseDTO;
import br.com.gustavomarmo.to_do_list.dto.TaskResponseIdDTO;
import br.com.gustavomarmo.to_do_list.mapper.TaskMapper;
import br.com.gustavomarmo.to_do_list.model.Task;
import br.com.gustavomarmo.to_do_list.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    List<TaskResponseDTO> list() {
        return taskMapper.responseDTOList((taskService.list()));
    }

    @GetMapping("/{id}")
    TaskResponseDTO find(@PathVariable Long id){
        return taskMapper.responseDTO(taskService.find(id));
    }

    @PostMapping
    TaskResponseIdDTO create(@Valid @RequestBody TaskRequestDTO dto){
        return taskMapper.responseIdDTO(taskService.create(taskMapper.responseEntity(dto)));
    }

    @PutMapping("/{id}")
    TaskResponseDTO update(@PathVariable("id") Long id, @Valid @RequestBody TaskRequestUpdateDTO updateDTO) {
        Task task = taskMapper.responseEntityUpdate(updateDTO);
        return taskMapper.responseDTO(taskService.update(id, task));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

}