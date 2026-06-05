package com.galinho.backend.dto.Estoque;

public record FornecedorDto(
    Long id,
    String nome,
    String cnpj,
    String email,
    String endereco
){
    
}
