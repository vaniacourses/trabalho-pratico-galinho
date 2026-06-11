package com.galinho.backend.model.Usuarios;

import com.galinho.backend.utils.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Mecanico extends Funcionario {
    
    private List<String> habilidades;

    public Mecanico(String email,
                   String senha,
                   String nome,
                   String cpf,
                   String telefone,
                   List<String> habilidades) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataCadastro = LocalDate.now();
        this.role = Role.MECANICO;
        this.habilidades = habilidades;
    }
}
