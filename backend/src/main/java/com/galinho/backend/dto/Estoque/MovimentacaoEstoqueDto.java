package com.galinho.backend.dto.Estoque;

import java.time.LocalDateTime;

import com.galinho.backend.utils.TipoMovimentacao;

public record MovimentacaoEstoqueDto (
    Long id,
    int quantidade,
    LocalDateTime data,
    String descricao,
    LoteProdutoDto loteDto,
    TipoMovimentacao tipo
) {

}
