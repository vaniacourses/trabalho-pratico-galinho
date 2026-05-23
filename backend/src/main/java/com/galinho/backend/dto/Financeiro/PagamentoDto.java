package com.galinho.backend.dto.Financeiro;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PagamentoDto(
        Long idPagamento,
        Long idServico,
        BigDecimal valorFinal,
        LocalDateTime dataPagamento,
        String tipoPagamento 
) {}