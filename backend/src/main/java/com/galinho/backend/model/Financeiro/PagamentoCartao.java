package com.galinho.backend.model.Financeiro;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) // considera os atributos de PagamentoServico para as comparacoes 
public class PagamentoCartao extends PagamentoServico {

    private String numeroCartao;
    private int quantidadeDeParcelas; 

    public PagamentoCartao(BigDecimal valorFinal, LocalDateTime data, String numeroCartao, int quantidadeDeParcelas) {
        super(valorFinal, data);
        this.numeroCartao = numeroCartao;
        this.quantidadeDeParcelas = quantidadeDeParcelas;
    }
}
