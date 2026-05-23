package com.galinho.backend.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.galinho.backend.dto.VeiculoCreate;
import com.galinho.backend.dto.VeiculoDto;
import com.galinho.backend.model.Servicos.Veiculo;

@Mapper(componentModel = "spring")
public interface MapperVeiculo {

    List<VeiculoDto> toVeiculosDto(List<Veiculo> veiculos);

    @Mapping(target = "servicos", ignore = true)
    VeiculoDto toVeiculoDto(Veiculo veiculo);

    @Mapping(target = "servicos", ignore = true)
    Veiculo toVeiculo(VeiculoCreate veiculoCreate);

    @Mapping(target = "servicos", ignore = true)
    Veiculo toVeiculo(VeiculoDto veiculoDto);
}
