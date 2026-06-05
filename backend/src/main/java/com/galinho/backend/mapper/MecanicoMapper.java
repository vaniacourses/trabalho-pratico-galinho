package com.galinho.backend.mapper;

import org.mapstruct.Mapper;

import com.galinho.backend.dto.MecanicoRequest;
import com.galinho.backend.dto.MecanicoResponse;
import com.galinho.backend.model.Usuarios.Mecanico;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MecanicoMapper {

    List<MecanicoResponse> toMecanicosResponse(List<Mecanico> mecanicos);

    MecanicoResponse toMecanicoResponse(Mecanico mecanico);

    Mecanico toMecanico(MecanicoRequest mecanicoRequest);
}
