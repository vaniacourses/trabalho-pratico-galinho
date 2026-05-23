package com.galinho.backend.service.Financeiro;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galinho.backend.dto.Financeiro.*;
import com.galinho.backend.model.Financeiro.*;
import com.galinho.backend.model.Servicos.Servico;
import com.galinho.backend.repository.Financeiro.PagamentoServicoRepository;
import com.galinho.backend.factory.Financeiro.*;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoServicoRepository pagamentoRepository;

    // Injecao das Fabricas
    @Autowired private PagamentoDinheiroFactory dinheiroFactory;
    @Autowired private PagamentoPixFactory pixFactory;
    @Autowired private PagamentoCartaoFactory cartaoFactory;

    public BigDecimal calcularTroco(BigDecimal quantiaRecebida, BigDecimal valorServico) {
        if (quantiaRecebida.compareTo(valorServico) < 0) {
            throw new IllegalArgumentException(
                "Pagamento recusado: A quantia recebida (R$ " + quantiaRecebida + 
                ") é menor que o valor do serviço (R$ " + valorServico + ")."
            );
        }
        return quantiaRecebida.subtract(valorServico);
    }

    public PagamentoDinheiro registrarPagamentoDinheiro(Servico servico, PagamentoDinheiroCreate dto) {
        calcularTroco(dto.quantiaRecebida(), servico.getOrcamento()); 
        PagamentoDinheiro dinheiro = dinheiroFactory.criarPagamento(servico.getOrcamento(), dto);
        dinheiro.setServico(servico);
        
        return pagamentoRepository.save(dinheiro);
    }

    public PagamentoPix registrarPagamentoPix(Servico servico, PagamentoPixCreate dto) {
        PagamentoPix pix = pixFactory.criarPagamento(servico.getOrcamento(), dto);
        pix.setServico(servico);

        return pagamentoRepository.save(pix);
    }

    public PagamentoCartao registrarPagamentoCartao(Servico servico, PagamentoCartaoCreate dto) {
        PagamentoCartao cartao = cartaoFactory.criarPagamento(servico.getOrcamento(), dto);
        cartao.setServico(servico);
        
        return pagamentoRepository.save(cartao);
    }
}