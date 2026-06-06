package com.galinho.backend.model.Estoque;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
public class LoteProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidade;
    private LocalDateTime validade;
    private String codigoLote;

    @OneToOne
    private Fornecedor fornecedor;
    
    @OneToOne
    private Produto produto;

    public LoteProduto(int quantidade, LocalDateTime validade, String codigoLote, Fornecedor fornecedor, Produto produto){
        this.quantidade = quantidade;
        this.validade = validade;
        this.codigoLote = codigoLote;
        this.fornecedor = fornecedor;
        this.produto = produto;
    }

    public boolean expirado() {
        return this.validade.isBefore(LocalDateTime.now());
    }
}
