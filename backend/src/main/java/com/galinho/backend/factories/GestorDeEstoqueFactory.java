package com.galinho.backend.factories;

import org.springframework.stereotype.Component;

import com.galinho.backend.model.Usuarios.GestorDeEstoque;

@Component
public class GestorDeEstoqueFactory implements UsuarioFactory {
    
    public GestorDeEstoque criarUsuario() {
        GestorDeEstoque usuario = new GestorDeEstoque();
        return usuario;
    }
}