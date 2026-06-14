package com.galinho.backend.mapper.Usuario;

import com.galinho.backend.dto.Usuario.ClienteRequest;
import com.galinho.backend.dto.Usuario.ClienteResponse;
import com.galinho.backend.model.Usuarios.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    List<ClienteResponse> toClientesResponse(List<Cliente> clientes);

    ClienteResponse toClienteResponse(Cliente cliente);

    Cliente toCliente(ClienteRequest clienteRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "senha", ignore = true)
    @Mapping(target = "cpf", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "dataCadastro", ignore = true)
    void updateCliente(ClienteRequest clienteRequest, @MappingTarget Cliente cliente);
}
