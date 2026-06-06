package com.galinho.backend.dto.Estoque;

public record ProdutoDto(
    Long codigo,
    String nome,
    String descricao,
    Double preco,
    Integer quantidadeMaxima,
    Integer quantidadeMinima,
    FornecedorDto fornecedorDto
) {
    
}
