package com.galinho.backend.mapper;

import com.galinho.backend.dto.ClienteRequest;
import com.galinho.backend.dto.ClienteResponse;
import com.galinho.backend.model.Usuarios.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    List<ClienteResponse> toClientesResponse(List<Cliente> clientes);

    ClienteResponse toClienteResponse(Cliente cliente);

    Cliente toCliente(ClienteRequest clienteRequest);
}
