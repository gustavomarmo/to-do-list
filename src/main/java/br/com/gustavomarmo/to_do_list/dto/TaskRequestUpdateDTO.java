package br.com.gustavomarmo.to_do_list.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class TaskRequestUpdateDTO {

    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres")
    private String nome;

    @Size(min = 5,max = 30, message = "A descrição deve ter no mínimo 5 caracteres")
    private String descricao;

    private Boolean realizado;

    @Positive(message = "A prioridade deve ser positiva")
    @Min(value = 1, message = "A prioridade deve ser entre 1 a 10")
    @Max(value = 10, message = "A prioridade deve ser entre 1 a 10")
    private Integer prioridade;
}
