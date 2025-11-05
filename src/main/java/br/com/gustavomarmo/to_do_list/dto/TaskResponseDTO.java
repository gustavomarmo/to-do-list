package br.com.gustavomarmo.to_do_list.dto;

import lombok.Data;

@Data
public class TaskResponseDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Boolean realizado;
    private Integer prioridade;
}
