package com.galinho.backend.dto.Usuario;

import com.galinho.backend.utils.Role;

import java.time.LocalDate;

public record ClienteResponse(Long id,
                              String email,
                              String senha,
                              String nome,
                              String cpf,
                              String telefone,
                              LocalDate dataCadastro,
                              String endereco,
                              Role role) {
}
