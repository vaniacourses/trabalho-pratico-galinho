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
public class PagamentoPix extends PagamentoServico {
    private String chave;

    public PagamentoPix(BigDecimal valorFinal, LocalDateTime data, String chave) {
        super(valorFinal, data);
        this.chave = chave;
    }
}