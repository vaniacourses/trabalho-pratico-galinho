package com.galinho.backend.factories.Financeiro;

import com.galinho.backend.dto.Financeiro.PagamentoPixCreate;
import com.galinho.backend.model.Financeiro.PagamentoPix;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.math.BigDecimal;

@Component
public class PagamentoPixFactory implements PagamentoFactory<PagamentoPix, PagamentoPixCreate> {

    @Override
    public PagamentoPix criarPagamento(BigDecimal valorOrcamento, PagamentoPixCreate dto) {
        return new PagamentoPix(valorOrcamento, LocalDateTime.now(), dto.chave());
    }
}