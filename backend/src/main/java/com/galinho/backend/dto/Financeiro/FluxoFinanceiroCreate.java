package com.galinho.backend.dto.Financeiro;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
                                @NotNull(message = "informe se ehEntrada")
                                Boolean ehEntrada,
                                @NotNull
                                LocalDateTime data,
                                @NotBlank(message = "infrome se eh origem ou  destino")
                                String origemOuDestino) {
}