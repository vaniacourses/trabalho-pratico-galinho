package com.galinho.backend.model.Estoque;

import java.time.LocalDateTime;

import com.galinho.backend.utils.TipoMovimentacao;

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
public class MovimentacaoEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidade;
    private LocalDateTime data;
    private String descricao;

    @OneToOne
    private LoteProduto lote;

    private TipoMovimentacao tipo;

    public MovimentacaoEstoque(int quantidade, String descricao, LoteProduto lote, TipoMovimentacao tipo){
        this.quantidade = quantidade;
        this.data = LocalDateTime.now();
        this.descricao = descricao;
        this.lote = lote;
        this.tipo = tipo;
    }
}
