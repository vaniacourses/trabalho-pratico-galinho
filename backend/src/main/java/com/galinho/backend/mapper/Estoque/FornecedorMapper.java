package com.galinho.backend.mapper.Estoque;

import java.util.List;

import org.mapstruct.Mapper;

import com.galinho.backend.model.Estoque.Fornecedor;
import com.galinho.backend.dto.Estoque.FornecedorCreate;
import com.galinho.backend.dto.Estoque.FornecedorDto;


@Mapper(componentModel = "spring")
public interface FornecedorMapper {
    List<FornecedorDto> toFornecedoresDto(List<Fornecedor> fornecedores);
    
    FornecedorDto toFornecedorDto(Fornecedor fornecedor);

    Fornecedor toFornecedor(FornecedorDto fornecedorDto);

    Fornecedor toFornecedor(FornecedorCreate fornecedorCreate);
    
}