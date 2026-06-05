package com.galinho.backend.dto.Financeiro;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PagamentoDinheiroCreate(
        @NotNull
        @Positive
        BigDecimal quantiaRecebida,
        @NotBlank(message = "titulo nao pode ficar em branco")
        String titulo
) {}