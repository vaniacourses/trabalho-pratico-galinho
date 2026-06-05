package com.galinho.backend.mapper.Usuario;

import org.mapstruct.Mapper;

import com.galinho.backend.dto.Usuario.GerenteRequest;
import com.galinho.backend.dto.Usuario.GerenteResponse;
import com.galinho.backend.model.Usuarios.Gerente;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GerenteMapper {

    List<GerenteResponse> toGerentesResponse(List<Gerente> gerentes);

    GerenteResponse toGerenteResponse(Gerente gerente);

    Gerente toGerente(GerenteRequest gerenteRequest);
}
