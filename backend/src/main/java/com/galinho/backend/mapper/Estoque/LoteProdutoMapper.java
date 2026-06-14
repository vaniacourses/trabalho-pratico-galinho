package com.galinho.backend.mapper.Estoque;

import java.util.List;

import org.mapstruct.Mapper;
import com.galinho.backend.dto.Estoque.LoteProdutoCreate;
import com.galinho.backend.dto.Estoque.LoteProdutoDto;
import com.galinho.backend.model.Estoque.LoteProduto;

@Mapper(componentModel = "spring")
public interface LoteProdutoMapper {
    
    List<LoteProdutoDto> toLotesProdutoDto(List<LoteProduto> lotes);

    LoteProdutoDto toLoteProdutoDto(LoteProduto lote);

    LoteProduto toLoteProduto(LoteProdutoDto loteProdutoDto);

    LoteProduto toLoteProduto(LoteProdutoCreate loteProdutoCreate);
}
