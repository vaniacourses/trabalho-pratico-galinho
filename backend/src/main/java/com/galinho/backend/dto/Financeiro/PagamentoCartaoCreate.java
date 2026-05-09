package com.galinho.backend.dto.Financeiro;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record PagamentoCartaoCreate(
        @NotBlank
        String numeroCartao,        
        @Min(value = 1, message = "pelo menos 1 parcela")
        int quantidadeDeParcelas
) {}
