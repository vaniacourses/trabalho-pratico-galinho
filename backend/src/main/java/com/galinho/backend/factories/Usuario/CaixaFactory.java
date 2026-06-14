package com.galinho.backend.factories.Usuario;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.galinho.backend.model.Usuarios.Caixa;
import com.galinho.backend.utils.Role;

@Component
public class CaixaFactory implements UsuarioFactory {

    public Caixa criarUsuario() {
        Caixa usuario = new Caixa();
        usuario.setDataCadastro(LocalDate.now());
        usuario.setRole(Role.CAIXA);
        return usuario;
    }
}