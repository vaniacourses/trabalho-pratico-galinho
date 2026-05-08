package com.galinho.backend.model.Financeiro;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.galinho.backend.model.Servicos.Servico;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED) // diz pra JPA que essa classe tem fii e faz o join 
public abstract class PagamentoServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valorFinal;
    private LocalDateTime data;

    @OneToOne
    private Servico servico;

    public PagamentoServico(BigDecimal valorFinal, LocalDateTime data) {
        this.valorFinal = valorFinal;
        this.data = data;
    }
}
