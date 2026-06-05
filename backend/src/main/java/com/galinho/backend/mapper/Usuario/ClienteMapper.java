package com.galinho.backend.mapper.Usuario;

import com.galinho.backend.dto.Usuario.ClienteRequest;
import com.galinho.backend.dto.Usuario.ClienteResponse;
import com.galinho.backend.model.Usuarios.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    List<ClienteResponse> toClientesResponse(List<Cliente> clientes);

    ClienteResponse toClienteResponse(Cliente cliente);

    Cliente toCliente(ClienteRequest clienteRequest);
}
