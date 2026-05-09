package com.galinho.backend.dto.Financeiro;

import jakarta.validation.constraints.NotBlank;

public record PagamentoPixCreate(
        @NotBlank
        String chave
) {}