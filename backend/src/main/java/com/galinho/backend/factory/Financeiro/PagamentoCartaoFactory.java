package com.galinho.backend.factory.Financeiro;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.galinho.backend.dto.Financeiro.PagamentoCartaoCreate;
import com.galinho.backend.model.Financeiro.PagamentoCartao;

@Component
public class PagamentoCartaoFactory implements PagamentoFactory<PagamentoCartao, PagamentoCartaoCreate> {
    @Override
    public PagamentoCartao criarPagamento(BigDecimal valorOrcamento, PagamentoCartaoCreate dto) {
        return new PagamentoCartao(valorOrcamento, LocalDateTime.now(), dto.numeroCartao(), dto.quantidadeDeParcelas());
    }
}
