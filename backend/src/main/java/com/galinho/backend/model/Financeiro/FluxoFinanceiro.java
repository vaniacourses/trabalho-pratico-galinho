package com.galinho.backend.model.Financeiro;

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

@Entity
@NoArgsConstructor
@Getter
@Setter
public class FluxoFinanceiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;
    private String titulo;
    private String descricao;
    private Boolean ehEntrada;

    // @Column(name = "origem_destino") -- da pra mapear com um nome melhor que da var real
    private String origemOuDestino;

    @ManyToOne
    @JoinColumn(name = "historico_id")
    private HistoricoFinanceiro historico;

    public FluxoFinanceiro(BigDecimal valor, String titulo, String descricao, Boolean ehEntrada, String origemOuDestino, HistoricoFinanceiro historico) {
        this.valor = valor;
        this.titulo = titulo;
        this.descricao = descricao;
        this.ehEntrada = ehEntrada;
        this.origemOuDestino = origemOuDestino;
        this.historico = historico;
    }
}
