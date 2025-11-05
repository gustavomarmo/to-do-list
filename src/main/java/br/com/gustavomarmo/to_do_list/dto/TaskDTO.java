package br.com.gustavomarmo.to_do_list.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class TaskDTO {

    @Null(message = "O ID não pode ser enviado no corpo da requisição")
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco")
    @Length(min = 3, message = "O nome deve ter no mínimo 3 caracteres")
    private String nome;

    @NotBlank(message = "A descrição não pode estar em branco")
    @Length(min = 5,max = 30, message = "A descrição deve ter no mínimo 5 caracteres")
    private String descricao;

    @NotNull(message = "O campo 'realizado' é obrigatório")
    private Boolean realizado;

    @NotNull (message = "É obrigatório colocar uma mensagem")
    @Positive(message = "A prioridade deve ser positiva")
    @Min(value = 1, message = "A prioridade deve ser entre 1 a 10")
    @Max(value = 10, message = "A prioridade deve ser entre 1 a 10")
    private Integer prioridade;
}
