package com.galinho.backend.factories.Usuario;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.galinho.backend.model.Usuarios.Mecanico;
import com.galinho.backend.utils.Role;

@Component
public class MecanicoFactory implements UsuarioFactory {
    
    public Mecanico criarUsuario() {
        Mecanico usuario = new Mecanico();
        usuario.setDataCadastro(LocalDate.now());
        usuario.setRole(Role.MECANICO);
        return usuario;
    }
}