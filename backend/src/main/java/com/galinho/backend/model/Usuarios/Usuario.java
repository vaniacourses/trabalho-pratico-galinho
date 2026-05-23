package com.galinho.backend.model.Usuarios;

import java.sql.Date;

import com.galinho.backend.utils.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;
    private String nome;
    private String cpf;
    private String telefone;
    private Date dataCadastro;

    @Enumerated(EnumType.STRING)
    private Role role;

    // getters e setters
}