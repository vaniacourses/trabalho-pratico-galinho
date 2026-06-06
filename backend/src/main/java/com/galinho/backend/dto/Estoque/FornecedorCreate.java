package com.galinho.backend.dto.Estoque;

public record FornecedorCreate(
    String nome,
    String cnpj,
    String email,
    String endereco
) {
    
}
