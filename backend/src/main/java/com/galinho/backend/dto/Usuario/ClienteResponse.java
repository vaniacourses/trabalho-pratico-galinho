package com.galinho.backend.dto.Usuario;

import java.time.LocalDate;

public record ClienteResponse(Long id,
                              String email,
                              String nome,
                              String cpf,
                              String telefone,
                              LocalDate dataCadastro,
                              String endereco) {
}
