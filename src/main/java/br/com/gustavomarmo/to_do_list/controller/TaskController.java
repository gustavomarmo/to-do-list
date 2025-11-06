package br.com.gustavomarmo.to_do_list.controller;

import br.com.gustavomarmo.to_do_list.dto.TaskRequestDTO;
import br.com.gustavomarmo.to_do_list.dto.TaskRequestUpdateDTO;
import br.com.gustavomarmo.to_do_list.dto.TaskResponseDTO;
import br.com.gustavomarmo.to_do_list.dto.TaskResponseIdDTO;
import br.com.gustavomarmo.to_do_list.mapper.TaskMapper;
import br.com.gustavomarmo.to_do_list.model.Task;
import br.com.gustavomarmo.to_do_list.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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

    @Operation(summary ="Listar todas as tarefas", description = "Busca as tarefas de acordo com a paginação")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a lista de tarefas"),
            @ApiResponse(responseCode = "500", description = "Retorna: 'Internal Server Error'")
    })
    @GetMapping
    List<TaskResponseDTO> list(@RequestParam int page,
                               @RequestParam int itens) {
        return taskMapper.responseDTOList((taskService.list(page, itens)));
    }

    @Operation(summary ="Buscar a tarefa pelo id", description = "Busca uma única tarefa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a tarefa"),
            @ApiResponse(responseCode = "404", description = "Retorna: 'ID not found: {id}'"),
            @ApiResponse(responseCode = "500", description = "Retorna: 'Internal Server Error'")
    })
    @GetMapping("/{id}")
    TaskResponseDTO find(@PathVariable Long id){
        return taskMapper.responseDTO(taskService.find(id));
    }

    @Operation(summary = "Criar uma nova tarefa")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    TaskResponseIdDTO create(@Valid @RequestBody TaskRequestDTO dto){
        return taskMapper.responseIdDTO(taskService.create(taskMapper.responseEntity(dto)));
    }

    @Operation(summary = "Atualizar a tarefa pelo id")
    @PutMapping("/{id}")
    TaskResponseDTO update(@PathVariable("id") Long id, @Valid @RequestBody TaskRequestUpdateDTO updateDTO) {
        Task task = taskMapper.responseEntityUpdate(updateDTO);
        return taskMapper.responseDTO(taskService.update(id, task));
    }

    @Operation(summary = "Remover a tarefa pelo id")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

}