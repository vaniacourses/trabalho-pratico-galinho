package com.galinho.backend.service.Financeiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galinho.backend.dto.Financeiro.PagamentoDTO;
import com.galinho.backend.mapper.Financeiro.FinanceiroMapper;
import com.galinho.backend.repository.Financeiro.HistoricoFinanceiroRepository;
import com.galinho.backend.repository.Financeiro.PagamentoServicoRepository;

import jakarta.transaction.Transactional;

@Service
public class FinanceiroService {
    @Autowired
    private PagamentoServicoRepository pagamentoRepository;
    @Autowired
    private HistoricoFinanceiroRepository historicoFinaceiro;
    //@Autowired
    //private ServicoRepository servicoRepository;
    @Autowired
    private FinanceiroMapper financeiroMapper;

    
    public Boolean verificarServicoConcluido

}
