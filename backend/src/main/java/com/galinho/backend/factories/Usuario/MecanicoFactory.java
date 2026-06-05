package com.galinho.backend.factories.Usuario;

import org.springframework.stereotype.Component;

import com.galinho.backend.model.Usuarios.Mecanico;

@Component
public class MecanicoFactory implements UsuarioFactory {
    
    public Mecanico criarUsuario() {
        Mecanico usuario = new Mecanico();
        return usuario;
    }
}