package com.galinho.backend.dto.Estoque;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Null;

public record LoteProdutoCreate (
    @Null Long id,
    int quantidade,
    LocalDateTime validade,
    String codigoLote,
    Long fornecedorId,
    Long produtoId 
) {
    
}
