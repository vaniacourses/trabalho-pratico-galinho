package com.galinho.backend.controller;

import com.galinho.backend.dto.ClienteRequest;
import com.galinho.backend.dto.ClienteResponse;
import com.galinho.backend.service.ClienteService;
import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteResponse> recuperarClientes() {
        return clienteService.recuperarClientes();
    }

    @GetMapping("{idCliente}")
    public ClienteResponse recuperarClientePorId(@PathVariable("idCliente") Long id) {
        return clienteService.recuperarClientePorId(id);
    }

    public ClienteResponse recuperarClientePorEmail(String email) {
        return clienteService.recuperarClientePorEmail(email);
    }

    @PostMapping
    public ClienteResponse cadastrarCliente(@RequestBody @Validated({Default.class, ClienteRequest.OnCreate.class}) ClienteRequest clienteRequest) {
        return clienteService.cadastrarCliente(clienteRequest);
    }

    @PutMapping
    public ClienteResponse alterarCliente(@RequestBody @Validated({Default.class, ClienteRequest.OnUpdate.class}) ClienteRequest clienteRequest) {
        return clienteService.alterarCliente(clienteRequest);
    }

    @DeleteMapping("{idCliente}")
    public void removerClientePorId(@PathVariable("idCliente") Long id) {
        clienteService.removerClientePorId(id);
    }

}
