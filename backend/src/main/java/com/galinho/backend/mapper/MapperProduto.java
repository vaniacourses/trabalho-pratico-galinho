package com.galinho.backend.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.galinho.backend.dto.ProdutoCreate;
import com.galinho.backend.dto.ProdutoDto;
import com.galinho.backend.model.Estoque.Produto;

@Mapper(componentModel = "spring")
public interface MapperProduto{

    List<ProdutoDto> toProdutosDto(List<Produto> produtos);

    ProdutoDto toProdutoDto(Produto produto);

    Produto toProduto(ProdutoDto produtoDto);

    Produto toProduto(ProdutoCreate produtoCreate);
    
}
