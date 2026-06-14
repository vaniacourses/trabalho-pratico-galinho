package com.galinho.backend.model.Estoque;

import java.math.BigDecimal;

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
    private long id;
    private int codigo;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidadeMaxima;
    private Integer quantidadeMinima;

    public Produto(int codigo, String nome, String descricao, BigDecimal preco, Integer quantidadeMaxima, Integer quantidadeMinima) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeMaxima = quantidadeMaxima;
        this.quantidadeMinima = quantidadeMinima;
    }
}
