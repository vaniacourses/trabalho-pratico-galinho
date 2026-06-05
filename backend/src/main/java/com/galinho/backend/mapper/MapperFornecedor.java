package com.galinho.backend.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.galinho.backend.dto.FornecedorCreate;
import com.galinho.backend.dto.FornecedorDto;
import com.galinho.backend.model.Estoque.Fornecedor;
import com.galinho.backend.dto.ProdutoDto;
import com.galinho.backend.model.Estoque.Produto;



@Mapper(componentModel = "spring")
public interface MapperFornecedor {
    List<FornecedorDto> toFornecedoresDto(List<Fornecedor> fornecedores);
    
    FornecedorDto toFornecedorDto(Fornecedor fornecedor);

    Fornecedor toFornecedor(FornecedorDto fornecedorDto);

    Fornecedor toFornecedor(FornecedorCreate fornecedorCreate);


}