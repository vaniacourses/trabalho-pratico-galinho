package com.galinho.backend.dto;

import java.util.List;

public record FornecedorDto(
    Long id,
    String nome,
    String cnpj,
    String email,
    String endereco,
    List<ProdutoDto> produtos
){
    
}
