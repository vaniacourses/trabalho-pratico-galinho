package com.galinho.backend.dto;

public record ProdutoCreate(
    String nome,
    String descricao,
    Double preco,
    Integer quantidadeMaxima,
    Integer quantidadeMinima,
    FornecedorDto fornecedor
) {
    
}
