package com.galinho.backend.service.Financeiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galinho.backend.dto.Financeiro.PagamentoCartaoCreate;
import com.galinho.backend.dto.Financeiro.PagamentoDinheiroCreate;
import com.galinho.backend.dto.Financeiro.PagamentoDto;
import com.galinho.backend.dto.Financeiro.PagamentoPixCreate;
import com.galinho.backend.exception.EntidadeNaoEncontradaException;
import com.galinho.backend.mapper.Financeiro.FinanceiroMapper;
import com.galinho.backend.model.Financeiro.PagamentoCartao;
import com.galinho.backend.model.Financeiro.PagamentoDinheiro;
import com.galinho.backend.model.Financeiro.PagamentoPix;
import com.galinho.backend.model.Servicos.Servico;
import com.galinho.backend.repository.ServicoRepository;

import jakarta.transaction.Transactional;

@Service
public class FinanceiroService { 
    @Autowired
    private FinanceiroMapper financeiroMapper;
    
    @Autowired
    private FluxoFinanceiroService fluxoService; 
    
    @Autowired
    private PagamentoService pagamentoService;
    
    @Autowired
    private ServicoRepository servicoRepository; 

    private Servico buscarServico(Long idServico) {
        return servicoRepository.findById(idServico)
                .orElseThrow(() ->
                        new EntidadeNaoEncontradaException(
                                "Serviço de id = " + idServico + " não encontrado."
                        )
                );
    }

    @Transactional
    public PagamentoDto registrarPagamentoDinheiro(Long idServico, PagamentoDinheiroCreate dto){ 
        Servico servico = buscarServico(idServico);
        PagamentoDinheiro dinheiro = pagamentoService.registrarPagamentoDinheiro(servico, dto);
        fluxoService.registrarEntradaDePagamento(dinheiro, "DINHEIRO", dto.titulo());
        
        return financeiroMapper.toPagamentoDto(dinheiro);
    }

    @Transactional
    public PagamentoDto registrarPagamentoPix(Long idServico, PagamentoPixCreate dto){
        Servico servico = buscarServico(idServico);
        PagamentoPix pix = pagamentoService.registrarPagamentoPix(servico, dto);      
        fluxoService.registrarEntradaDePagamento(pix, "PIX", dto.titulo());      
        
        return financeiroMapper.toPagamentoDto(pix);
    }
     
    @Transactional
    public PagamentoDto registrarPagamentoCartao(Long idServico, PagamentoCartaoCreate dto){
        Servico servico = buscarServico(idServico);
        PagamentoCartao cartao = pagamentoService.registrarPagamentoCartao(servico, dto);
        fluxoService.registrarEntradaDePagamento(cartao, "CARTAO", dto.titulo());
        
        return financeiroMapper.toPagamentoDto(cartao);
    }
}
