package com.galinho.backend.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.galinho.backend.dto.ServicoCreate;
import com.galinho.backend.dto.ServicoDto;
import com.galinho.backend.model.Servicos.Servico;

@Mapper(componentModel = "spring")
public interface ServicoMapper {
    
    List<ServicoDto> toServicosDto(List<Servico> servicos);

    ServicoDto toServicoDto(Servico servico);

    @Mapping(target = "mecanicos", ignore = true)
    @Mapping(target = "conjuntoTarefas", ignore = true)
    @Mapping(target = "produtosUsados", ignore = true)
    Servico toServico(ServicoDto servicoDto);

    @Mapping(target = "mecanicos", ignore = true)
    @Mapping(target = "conjuntoTarefas", ignore = true)
    @Mapping(target = "produtosUsados", ignore = true)
    Servico toServico(ServicoCreate servicoCreate);
}

