package br.com.gustavomarmo.to_do_list.dto;

import lombok.Data;

@Data
public class TodoDTO {
    private String nome;
    private String descricao;
    private boolean realizado;
    private int prioridade;
}
