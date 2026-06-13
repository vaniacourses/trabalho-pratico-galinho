package com.galinho.backend.model.Servicos.Tarefa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
public class TarefaAdicional extends TarefaDecorator{

    public TarefaAdicional(){}
    
    public TarefaAdicional(LocalDateTime data, BigDecimal valor, String descricao, TarefaEntity decorada){
        super(data, valor, descricao, decorada);
    }

    public BigDecimal calcularValor(){
        return tarefaDecorada.calcularValor().add(valor);
    }

    public String getDescricao(){
        //return tarefaDecorada.getDescricao().concat("\n" + descricao);
        return descricao;
    }

    @Override
    public TarefaEntity getTarefaDecorada() {
        return tarefaDecorada;
    }
}