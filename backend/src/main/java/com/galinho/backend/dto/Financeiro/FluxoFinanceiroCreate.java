package com.galinho.backend.dto.Financeiro;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.galinho.backend.utils.TipoMovimentacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;

public record FluxoFinanceiroCreate(@Null Long id, 
                                @NotNull
                                @Positive
                                BigDecimal valor,
                                @NotBlank
                                String titulo,
                                String descricao,
                                @NotNull(message = "informe se eh ENTRADA ou SAIDA")
                                TipoMovimentacao tipo,
                                @NotNull
                                LocalDateTime data,
                                @NotBlank(message = "infrome se eh origem ou  destino")
                                String origemOuDestino) {
}