package com.galinho.backend.factories.Financeiro;

import com.galinho.backend.dto.Financeiro.PagamentoDinheiroCreate;
import com.galinho.backend.model.Financeiro.PagamentoDinheiro;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.math.BigDecimal;
@Component
public class PagamentoDinheiroFactory implements PagamentoFactory<PagamentoDinheiro, PagamentoDinheiroCreate> {

    @Override
    public PagamentoDinheiro criarPagamento(BigDecimal valorOrcamento, PagamentoDinheiroCreate dto) {
        return new PagamentoDinheiro(valorOrcamento, LocalDateTime.now(), dto.quantiaRecebida());
    }
}