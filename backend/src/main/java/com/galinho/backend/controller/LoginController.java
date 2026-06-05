package com.galinho.backend.controller;

import com.galinho.backend.dto.LoginResponseDto;
import com.galinho.backend.dto.UsuarioLoginDto;
import com.galinho.backend.model.Usuarios.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public LoginResponseDto logar(@RequestBody @Valid UsuarioLoginDto usuarioLoginDto) {
        var senhaUsuario = new UsernamePasswordAuthenticationToken(usuarioLoginDto.email(), usuarioLoginDto.senha());
        var auth = this.authenticationManager.authenticate(senhaUsuario);

        Usuario usuarioLogado = (Usuario) auth.getPrincipal();

        return new LoginResponseDto(usuarioLogado.getId(), usuarioLogado.getRole());
    }
}
