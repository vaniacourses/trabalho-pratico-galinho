package com.galinho.backend.model.Financeiro;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.galinho.backend.utils.TipoMovimentacao;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FluxoFinanceiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;
    private String titulo;
    private String descricao;
    private LocalDateTime data;
    private String origemOuDestino;

    
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipo;

    // Construtor atualizado
    public FluxoFinanceiro(BigDecimal valor, String titulo, String descricao, TipoMovimentacao tipo, LocalDateTime data, String origemOuDestino) {
        this.valor = valor;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.data = data;
        this.origemOuDestino = origemOuDestino;
    }
}
