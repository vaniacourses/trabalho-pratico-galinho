package com.galinho.backend.dto.Financeiro;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.galinho.backend.utils.TipoMovimentacao;

public record FluxoFinanceiroDto(Long id,
                                BigDecimal valor,
                                String titulo,
                                String descricao,
                                TipoMovimentacao tipo,
                                LocalDateTime data,
                                String origemOuDestino) {
}
