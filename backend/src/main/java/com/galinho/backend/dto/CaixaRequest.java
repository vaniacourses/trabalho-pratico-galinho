package com.galinho.backend.dto;

import jakarta.validation.constraints.*;

public record CaixaRequest(
        @Null(groups = OnCreate.class, message = "Id deve ser nulo ao cadastrar.")
        @NotNull(groups = OnUpdate.class, message = "Id deve ser informado ao alterar.")
        Long id,

        @NotBlank(message = "Email não pode estar vazio.")
        @Email(message = "O formato do email é inválido.") String email,

        @NotBlank(message = "Senha não pode estar vazio.") String senha,

        @NotBlank(message = "Nome não pode estar vazio.") String nome,

        @NotBlank(message = "CPF não pode estar vazio.")
        @Size(min = 11, max = 11, message = "O formato do CPF é inválido.") String cpf,

        @NotBlank(message = "Telefone não pode estar vazio.")
        @Size(min = 11, max = 11, message = "O formato do telefone é inválido.") String telefone ) {
    public interface OnCreate {}
    public interface OnUpdate {}
}
