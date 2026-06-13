package com.galinho.backend.factories.Usuario;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.galinho.backend.model.Usuarios.Gerente;
import com.galinho.backend.utils.Role;

@Component
public class GerenteFactory implements UsuarioFactory {
    
    public Gerente criarUsuario() {
        Gerente usuario = new Gerente();
        usuario.setDataCadastro(LocalDate.now());
        usuario.setRole(Role.GERENTE);
        return usuario;
    }
}