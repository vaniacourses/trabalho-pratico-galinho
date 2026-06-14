package com.galinho.backend.model.Estoque;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidadeMaxima;
    private int quantidadeMinima;

    public Produto(String codigo, String nome, String descricao, double preco, int quantidadeMaxima, int quantidadeMinima){
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeMaxima = quantidadeMaxima;
        this.quantidadeMinima = quantidadeMinima;
    }
}
