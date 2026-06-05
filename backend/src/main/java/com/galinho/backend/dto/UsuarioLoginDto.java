package com.galinho.backend.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioLoginDto(@NotBlank(message = "Email não pode estar vazio.")
                              String email,

                              @NotBlank(message = "Senha não pode estar vazio.")
                              String senha) {
}
