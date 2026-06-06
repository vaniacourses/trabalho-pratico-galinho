package com.galinho.backend.dto.Estoque;

import java.time.LocalDateTime;

import com.galinho.backend.model.Estoque.Produto;

import jakarta.validation.constraints.Null;

public record LoteProdutoCreate (
    @Null Long id,
    int quantidade,
    LocalDateTime validade,
    String codigoLote,
    FornecedorDto fornecedorDto,
    Produto produto 
) {
    
}
