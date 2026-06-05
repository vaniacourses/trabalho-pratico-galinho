package com.galinho.backend.mapper;

import org.mapstruct.Mapper;

import com.galinho.backend.dto.GestorDeEstoqueRequest;
import com.galinho.backend.dto.GestorDeEstoqueResponse;
import com.galinho.backend.model.Usuarios.GestorDeEstoque;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GestorDeEstoqueMapper {

    List<GestorDeEstoqueResponse> toGestorDeEstoquesResponse(List<GestorDeEstoque> gestorDeEstoques);

    GestorDeEstoqueResponse toGestorDeEstoqueResponse(GestorDeEstoque gestorDeEstoque);

    GestorDeEstoque toGestorDeEstoque(GestorDeEstoqueRequest gestorDeEstoqueRequest);
}
