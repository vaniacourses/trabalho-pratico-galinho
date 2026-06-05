package com.galinho.backend.dto.Usuario;

import java.time.LocalDate;

public record GerenteResponse(Long id,
                            String email,
                            String nome,
                            String cpf,
                            String telefone,
                            LocalDate dataCadastro) {
}
