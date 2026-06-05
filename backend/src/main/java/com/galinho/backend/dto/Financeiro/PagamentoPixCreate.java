package com.galinho.backend.dto.Financeiro;

import jakarta.validation.constraints.NotBlank;

public record PagamentoPixCreate(
        @NotBlank(message = "chave nao pode ficar em branco")
        String chave,
        @NotBlank(message = "titulo nao pode ficar em branco")
        String titulo
) {}