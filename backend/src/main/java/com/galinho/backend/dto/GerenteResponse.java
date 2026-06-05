package com.galinho.backend.dto;

import java.time.LocalDate;

public record GerenteResponse(Long id,
                            String email,
                            String nome,
                            String cpf,
                            String telefone,
                            LocalDate dataCadastro) {
}
