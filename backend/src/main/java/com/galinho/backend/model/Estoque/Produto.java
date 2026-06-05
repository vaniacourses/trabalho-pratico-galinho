package com.galinho.backend.model.Estoque;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private int codigo;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidadeMaxima;
    private Integer quantidadeMinima;
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    Fornecedor fornecedor;
}
