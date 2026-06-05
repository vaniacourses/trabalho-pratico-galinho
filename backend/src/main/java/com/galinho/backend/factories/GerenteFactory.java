package com.galinho.backend.factories;

import org.springframework.stereotype.Component;

import com.galinho.backend.model.Usuarios.Gerente;

@Component
public class GerenteFactory implements UsuarioFactory {
    
    public Gerente criarUsuario() {
        Gerente usuario = new Gerente();
        return usuario;
    }
}