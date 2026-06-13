package com.galinho.backend.mapper.Estoque;

import java.util.List;

import org.mapstruct.Mapper;
import com.galinho.backend.dto.Estoque.MovimentacaoEstoqueCreate;
import com.galinho.backend.dto.Estoque.MovimentacaoEstoqueDto;
import com.galinho.backend.model.Estoque.MovimentacaoEstoque;

@Mapper(componentModel = "spring")
public interface MovimentacaoEstoqueMapper {
    
    List<MovimentacaoEstoqueDto> toMovimentacoesDto(List<MovimentacaoEstoque> movimentacoesEstoque);

    MovimentacaoEstoqueDto toMovimentacaoEstoqueDto(MovimentacaoEstoque movimentacaoEstoque);
    
    MovimentacaoEstoque toMovimentacaoEstoque(MovimentacaoEstoqueDto movimentacaoEstoqueDto);

    MovimentacaoEstoque toMovimentacaoEstoque(MovimentacaoEstoqueCreate movimentacaoEstoqueCreate);
}
