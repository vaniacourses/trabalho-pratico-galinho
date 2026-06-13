package com.galinho.backend.model.Estoque;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor


public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String cnpj;
    String email;
    String endereco;
    @OneToMany(mappedBy = "fornecedor")
    List<Produto> produtos;

    public Fornecedor(String nome, String cnpj, String email, String endereco, List<Produto> produtos) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.endereco = endereco;
        this.produtos = produtos;
    }

    
}
