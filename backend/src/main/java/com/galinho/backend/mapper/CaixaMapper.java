package com.galinho.backend.mapper;

import org.mapstruct.Mapper;

import com.galinho.backend.dto.CaixaRequest;
import com.galinho.backend.dto.CaixaResponse;
import com.galinho.backend.model.Usuarios.Caixa;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CaixaMapper {

    List<CaixaResponse> toCaixasResponse(List<Caixa> caixas);

    CaixaResponse toCaixaResponse(Caixa caixa);

    Caixa toCaixa(CaixaRequest caixaRequest);
}
