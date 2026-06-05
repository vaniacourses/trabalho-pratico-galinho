package com.galinho.backend.mapper.Estoque;

import java.util.List;

import org.mapstruct.Mapper;

import com.galinho.backend.dto.Estoque.ProdutoCreate;
import com.galinho.backend.dto.Estoque.ProdutoDto;
import com.galinho.backend.model.Estoque.Produto;

@Mapper(componentModel = "spring")
public interface ProdutoMapper{

    List<ProdutoDto> toProdutosDto(List<Produto> produtos);

    ProdutoDto toProdutoDto(Produto produto);

    Produto toProduto(ProdutoDto produtoDto);

    Produto toProduto(ProdutoCreate produtoCreate);
    
}
