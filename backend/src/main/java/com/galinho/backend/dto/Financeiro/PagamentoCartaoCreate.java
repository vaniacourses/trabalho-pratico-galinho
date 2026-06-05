package com.galinho.backend.dto.Financeiro;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record PagamentoCartaoCreate(
        @NotBlank(message = "numero do cartao nao pode ficar em branco")
        String numeroCartao,        
        @Min(value = 1, message = "pelo menos 1 parcela")
        int quantidadeDeParcelas,
        @NotBlank(message = "titulo nao pode ficar em branco")
        String titulo
) {}
