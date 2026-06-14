package com.galinho.backend.dto.Estoque;

public record ProdutoDto(
    Long id,
    Long codigo,
    String nome,
    String descricao,
    Double preco,
    Integer quantidadeMaxima,
    Integer quantidadeMinima
) {
    
}
