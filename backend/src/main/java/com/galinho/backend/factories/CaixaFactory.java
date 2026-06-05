package com.galinho.backend.factories;

import org.springframework.stereotype.Component;

import com.galinho.backend.model.Usuarios.Caixa;

@Component
public class CaixaFactory implements UsuarioFactory {

    public Caixa criarUsuario() {
        Caixa usuario = new Caixa();
        return usuario;
    }
}