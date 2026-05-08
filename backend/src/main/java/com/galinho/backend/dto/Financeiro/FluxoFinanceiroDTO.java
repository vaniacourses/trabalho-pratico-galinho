package com.galinho.backend.dto.Financeiro;

import java.math.BigDecimal;

public record FluxoFinanceiroDTO(BigDecimal valor,
                                String titulo,
                                String descricao,
                                Boolean ehEntrada,
                                String origemOuDestino) {
                                    
}
