package com.galinho.backend.factories.Usuario;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.galinho.backend.model.Usuarios.GestorDeEstoque;
import com.galinho.backend.utils.Role;

@Component
public class GestorDeEstoqueFactory implements UsuarioFactory {
    
    public GestorDeEstoque criarUsuario() {
        GestorDeEstoque usuario = new GestorDeEstoque();
        usuario.setDataCadastro(LocalDate.now());
        usuario.setRole(Role.GESTOR_ESTOQUE);
        return usuario;
    }
}