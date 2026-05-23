package com.galinho.backend.model.Servicos.Tarefa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;

public abstract class TarefaDecorator extends TarefaEntity{
    @OneToOne(cascade = CascadeType.ALL)
    protected TarefaEntity tarefaDecorada;
    protected LocalDateTime data;
    protected BigDecimal valor;
    protected String descricao;

    public abstract BigDecimal calcularValor();
    
    public TarefaDecorator(){};
    
    public TarefaDecorator(LocalDateTime data, BigDecimal valor, String descricao, TarefaEntity decorada){
        tarefaDecorada = decorada;
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
    }
    
}
