package com.galinho.backend.dto.Financeiro;

import java.math.BigDecimal;

public record HistoricoFinanceiroDTO(
        Long id,
        BigDecimal saldoAtual,
        BigDecimal quantiaDeEntrada,
        BigDecimal quantiaDeSaida
) {}