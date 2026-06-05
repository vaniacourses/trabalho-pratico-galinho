package com.galinho.backend.service;

import com.galinho.backend.dto.ClienteRequest;
import com.galinho.backend.dto.ClienteResponse;
import com.galinho.backend.exception.EntidadeNaoEncontradaException;
import com.galinho.backend.factories.ClienteFactory;
import com.galinho.backend.mapper.ClienteMapper;
import com.galinho.backend.model.Usuarios.Cliente;
import com.galinho.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private ClienteFactory clienteFactory;

    public List<ClienteResponse> recuperarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clienteMapper.toClientesResponse(clientes);
    }

    public ClienteResponse recuperarClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Cliente com Id = " + id + " não encontrado."));
        return clienteMapper.toClienteResponse(cliente);
    }

    public ClienteResponse recuperarClientePorEmail(String email) {
        Cliente cliente = clienteRepository.findByEmail(email);
        return clienteMapper.toClienteResponse(cliente);
    }

    public ClienteResponse cadastrarCliente(ClienteRequest clienteRequest) {
        if(recuperarClientePorEmail(clienteRequest.email()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email já cadastrado.");
        }
        String senhaCripto = new BCryptPasswordEncoder().encode(clienteRequest.senha());
        
        Cliente cliente = clienteFactory.criarUsuario();
        cliente.setEmail(clienteRequest.email());
        cliente.setSenha(senhaCripto);
        cliente.setNome(clienteRequest.nome());
        cliente.setCpf(clienteRequest.cpf());
        cliente.setTelefone(clienteRequest.telefone());
        cliente.setEndereco(clienteRequest.endereco());
        
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toClienteResponse(cliente);
    }

    public ClienteResponse alterarCliente(ClienteRequest clienteRequest) {
        Cliente cliente = clienteMapper.toCliente(clienteRequest);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toClienteResponse(cliente);
    }

    public void removerClientePorId(Long id) {
        recuperarClientePorId(id);
        clienteRepository.deleteById(id);
    }

}
