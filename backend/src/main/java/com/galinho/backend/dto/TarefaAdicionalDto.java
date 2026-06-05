package com.galinho.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarefaAdicionalDto extends TarefaDto {
    private BigDecimal valor;
    private LocalDateTime data;
    private TarefaDto tarefa; //tarefa decorada
}