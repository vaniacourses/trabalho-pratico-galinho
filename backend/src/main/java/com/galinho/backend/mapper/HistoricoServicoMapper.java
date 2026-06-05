package com.galinho.backend.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.galinho.backend.dto.HistoricoServicoDto;
import com.galinho.backend.model.Servicos.HistoricoServico;

@Mapper(componentModel = "spring", uses = ServicoMapper.class)
public interface HistoricoServicoMapper {
    
    List<HistoricoServicoDto> toHistoricoServicosDto(List<HistoricoServico> historicoServicos);

    @Mapping(source = "servico", target = "servicoDto")
    HistoricoServicoDto toHistoricoServicoDto(HistoricoServico historicoServico);

    @Mapping(source = "servicoDto", target = "servico")
    HistoricoServico toHistoricoServico(HistoricoServicoDto historicoServicoDto);
}
