package com.galinho.backend.model.Usuarios;

import com.galinho.backend.utils.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
public class Gerente extends Funcionario {

    public Gerente(String email,
                   String senha,
                   String nome,
                   String cpf,
                   String telefone) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataCadastro = LocalDate.now();
        this.role = Role.GERENTE;
    }
}
