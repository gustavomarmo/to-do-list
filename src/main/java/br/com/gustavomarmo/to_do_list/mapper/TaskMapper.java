package br.com.gustavomarmo.to_do_list.mapper;

import br.com.gustavomarmo.to_do_list.dto.TaskDTO;
import br.com.gustavomarmo.to_do_list.dto.TaskUpdateDTO;
import br.com.gustavomarmo.to_do_list.model.Task;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TaskMapper {

    public Task responseEntity(TaskDTO dto){
        Task task = new Task();

        task.setNome(dto.getNome());
        task.setDescricao(dto.getDescricao());
        task.setRealizado(dto.getRealizado());
        task.setPrioridade(dto.getPrioridade());

        return task;
    }
    public Task responseEntityUpdate(TaskUpdateDTO dto){
        Task task = new Task();

        task.setNome(dto.getNome());
        task.setDescricao(dto.getDescricao());
        task.setRealizado(dto.getRealizado());
        task.setPrioridade(dto.getPrioridade());

        return task;
    }

    public TaskDTO responseDTO(Task task){
        TaskDTO dto = new TaskDTO();

        dto.setId(task.getId());
        dto.setNome(task.getNome());
        dto.setDescricao(task.getDescricao());
        dto.setRealizado(task.isRealizado());
        dto.setPrioridade(task.getPrioridade());

        return dto;
    }

    public List<TaskDTO> responseDTOList(List<Task> taskList) {
        return taskList.stream()
                .map(this::responseDTO)
                .toList();
    }
}
