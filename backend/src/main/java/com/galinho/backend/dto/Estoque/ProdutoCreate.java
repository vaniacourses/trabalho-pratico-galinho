package com.galinho.backend.dto.Estoque;

public record ProdutoCreate(
    String nome,
    String descricao,
    Double preco,
    int quantidadeMaxima,
    int quantidadeMinima,
    FornecedorDto fornecedorDto
) {
    
}
