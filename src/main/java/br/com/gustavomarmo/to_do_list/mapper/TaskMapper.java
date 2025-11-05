package br.com.gustavomarmo.to_do_list.mapper;

import br.com.gustavomarmo.to_do_list.dto.TaskRequestDTO;
import br.com.gustavomarmo.to_do_list.dto.TaskRequestUpdateDTO;
import br.com.gustavomarmo.to_do_list.dto.TaskResponseDTO;
import br.com.gustavomarmo.to_do_list.dto.TaskResponseIdDTO;
import br.com.gustavomarmo.to_do_list.model.Task;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TaskMapper {

    public Task responseEntity(TaskRequestDTO dto){
        Task task = new Task();

        task.setNome(dto.getNome());
        task.setDescricao(dto.getDescricao());
        task.setRealizado(dto.getRealizado());
        task.setPrioridade(dto.getPrioridade());

        return task;
    }
    public Task responseEntityUpdate(TaskRequestUpdateDTO dto){
        Task task = new Task();

        task.setNome(dto.getNome());
        task.setDescricao(dto.getDescricao());
        task.setRealizado(dto.getRealizado());
        task.setPrioridade(dto.getPrioridade());

        return task;
    }

    public TaskResponseDTO responseDTO(Task task){
        TaskResponseDTO dto = new TaskResponseDTO();

        dto.setId(task.getId());
        dto.setNome(task.getNome());
        dto.setDescricao(task.getDescricao());
        dto.setRealizado(task.isRealizado());
        dto.setPrioridade(task.getPrioridade());

        return dto;
    }

    public TaskResponseIdDTO responseIdDTO(Task task){
        TaskResponseIdDTO dto = new TaskResponseIdDTO();

        dto.setId(task.getId());

        return dto;
    }

    public List<TaskResponseDTO> responseDTOList(List<Task> taskList) {
        return taskList.stream()
                .map(this::responseDTO)
                .toList();
    }
}
