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
public class PagamentoDinheiro extends PagamentoServico{
    private BigDecimal quantiaRecebida;

    public PagamentoDinheiro(BigDecimal valorFinal, LocalDateTime data, BigDecimal quantiaRecebida) {
        super(valorFinal, data);
        this.quantiaRecebida = quantiaRecebida;
    }
}
