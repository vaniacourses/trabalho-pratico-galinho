package com.galinho.backend.dto.Usuario;

import java.time.LocalDate;
import java.util.List;

public record MecanicoResponse(Long id,
                              String email,
                              String nome,
                              String cpf,
                              String telefone,
                              LocalDate dataCadastro,
                              List<String> habilidades) {
}
