package com.galinho.backend.model.Servicos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.galinho.backend.utils.TipoStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
public class HistoricoServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private String descricao;

    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
    private TipoStatus statusDoMomento;
    private BigDecimal orcamentoDoMomento;

    @ManyToOne
    private Servico servico;

    public HistoricoServico(TipoStatus status, BigDecimal orcamento, Servico servico, String descricao){
        statusDoMomento = status;
        orcamentoDoMomento = orcamento;
        this.servico = servico;
        this.date = LocalDateTime.now();
        this.descricao = descricao;
    }
}
