package br.com.gustavomarmo.to_do_list.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "todos") // Nome da tabela no banco
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cria uma sequência aleatória lá no banco
    private Long id; // Identificado único do registro no banco
    private String nome;
    private String descricao;
    private boolean realizado;
    private int prioridade;

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }
}