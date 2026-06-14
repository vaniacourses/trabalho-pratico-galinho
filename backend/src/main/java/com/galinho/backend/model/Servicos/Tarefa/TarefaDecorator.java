package com.galinho.backend.model.Servicos.Tarefa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class TarefaDecorator extends TarefaEntity{
    @OneToOne(cascade = CascadeType.ALL)
    protected TarefaEntity tarefaDecorada;
    protected LocalDateTime data;
    protected BigDecimal valor;
    protected BigDecimal valorTotal;
    protected String descricao;

    public abstract BigDecimal calcularValor();
    public abstract String getDescricao();
    public abstract String getDescricaoTotal();
    
    protected TarefaDecorator(){}
    
    protected TarefaDecorator(LocalDateTime data, BigDecimal valor, String descricao, TarefaEntity decorada){
        tarefaDecorada = decorada;
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
        this.valorTotal = calcularValor();
    }
    
}
