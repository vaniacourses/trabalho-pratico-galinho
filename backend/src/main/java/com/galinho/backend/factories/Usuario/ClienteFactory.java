package com.galinho.backend.factories.Usuario;

import org.springframework.stereotype.Component;

import com.galinho.backend.model.Usuarios.Cliente;

@Component
public class ClienteFactory implements UsuarioFactory {
    
    public Cliente criarUsuario() {
        Cliente usuario = new Cliente();
        return usuario;
    }
}