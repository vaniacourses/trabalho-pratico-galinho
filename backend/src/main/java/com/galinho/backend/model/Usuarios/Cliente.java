package com.galinho.backend.model.Usuarios;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.galinho.backend.model.Servicos.Veiculo;

import com.galinho.backend.utils.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Cliente extends Usuario {

    private String endereco;
    
    @OneToMany
    @JsonIgnore
    private List<Veiculo> veiculos;

    public Cliente(String email,
                   String senha,
                   String nome,
                   String cpf,
                   String telefone,
                   String endereco) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataCadastro = LocalDate.now();
        this.role = Role.CLIENTE;
        this.endereco = endereco;
        this.veiculos = new ArrayList<>();
    }
}
