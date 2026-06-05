package com.galinho.backend.dto;

import java.time.LocalDate;

public record GestorDeEstoqueResponse(Long id,
                            String email,
                            String nome,
                            String cpf,
                            String telefone,
                            LocalDate dataCadastro) {
}
