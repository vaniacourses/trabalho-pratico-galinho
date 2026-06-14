package com.galinho.backend.factories.Usuario;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.galinho.backend.model.Usuarios.Cliente;
import com.galinho.backend.utils.Role;

@Component
public class ClienteFactory implements UsuarioFactory {
    
    public Cliente criarUsuario() {
        Cliente usuario = new Cliente();
        usuario.setDataCadastro(LocalDate.now());
        usuario.setRole(Role.CLIENTE);
        return usuario;
    }
}