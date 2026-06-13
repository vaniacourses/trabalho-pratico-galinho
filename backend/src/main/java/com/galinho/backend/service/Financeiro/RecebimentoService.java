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
import com.galinho.backend.model.Financeiro.PagamentoServico;
import com.galinho.backend.model.Servicos.Servico;
import com.galinho.backend.repository.ServicoRepository;

import jakarta.transaction.Transactional;

@Service
public class RecebimentoService { 
    @Autowired
    private FinanceiroMapper financeiroMapper;
    
    @Autowired
    private RegistroFinanceiroService registroService; 
    
    @Autowired
    private ProcessarPagamentoService pagamentoService;
    
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

   private void pagarServico(Servico servico, PagamentoServico pagamento) {
        servico.setPagamento(pagamento);
        servico.setStatus(com.galinho.backend.utils.TipoStatus.CONCLUIDO);
        servicoRepository.save(servico);
    }

    @Transactional
    public PagamentoDto registrarPagamentoDinheiro(Long idServico, PagamentoDinheiroCreate dto){ 
        Servico servico = buscarServico(idServico);
        PagamentoDinheiro dinheiro = pagamentoService.registrarPagamentoDinheiro(servico, dto);
        registroService.registrarEntradaDePagamento(dinheiro, "DINHEIRO", dto.titulo());
        pagarServico(servico, dinheiro);
        
        return financeiroMapper.toPagamentoDto(dinheiro);
    }

    @Transactional
    public PagamentoDto registrarPagamentoPix(Long idServico, PagamentoPixCreate dto){
        Servico servico = buscarServico(idServico);
        PagamentoPix pix = pagamentoService.registrarPagamentoPix(servico, dto);      
        registroService.registrarEntradaDePagamento(pix, "PIX", dto.titulo());  
        pagarServico(servico, pix);
        
        
        return financeiroMapper.toPagamentoDto(pix);
    }
     
    @Transactional
    public PagamentoDto registrarPagamentoCartao(Long idServico, PagamentoCartaoCreate dto){
        Servico servico = buscarServico(idServico);
        PagamentoCartao cartao = pagamentoService.registrarPagamentoCartao(servico, dto);
        registroService.registrarEntradaDePagamento(cartao, "CARTAO", dto.titulo());
        pagarServico(servico, cartao);
        
        return financeiroMapper.toPagamentoDto(cartao);
    }
}
