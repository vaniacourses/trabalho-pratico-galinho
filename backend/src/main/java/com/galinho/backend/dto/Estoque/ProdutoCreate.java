package com.galinho.backend.dto.Estoque;
import jakarta.validation.constraints.Null;

public record ProdutoCreate(
    @Null
    Long id,
    int codigo,
    String nome,
    String descricao,
    Double preco,
    int quantidadeMaxima,
    int quantidadeMinima
) {
    
}
