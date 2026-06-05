package com.galinho.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarefaDto {
    private Long id;
    private String descricao;
    // private BigDecimal valor;
    // private LocalDateTime data;
}