package com.galinho.backend.model.Servicos.Tarefa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
public class TarefaSimples extends TarefaEntity{
    private LocalDateTime data;
    private BigDecimal valor;
    private String descricao;

    public TarefaSimples(LocalDateTime data, BigDecimal valor, String descricao){
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
    }

    public BigDecimal calcularValor(){
        return valor;
    }

    public String getDescricao(){
        return descricao;
    }
    
    public String getDescricaoTotal(){
        return descricao;
    }

}
