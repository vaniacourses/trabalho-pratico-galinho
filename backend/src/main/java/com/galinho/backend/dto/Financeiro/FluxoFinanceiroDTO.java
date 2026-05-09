package com.galinho.backend.dto.Financeiro;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FluxoFinanceiroDTO(Long id,
                                BigDecimal valor,
                                String titulo,
                                String descricao,
                                Boolean ehEntrada,
                                LocalDateTime data,
                                String origemOuDestino) {
}
