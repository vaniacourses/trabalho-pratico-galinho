package com.galinho.backend.service.Financeiro;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galinho.backend.dto.Financeiro.FluxoFinanceiroCreate;
import com.galinho.backend.dto.Financeiro.FluxoFinanceiroDto;
import com.galinho.backend.mapper.Financeiro.FinanceiroMapper;
import com.galinho.backend.model.Financeiro.FluxoFinanceiro;
import com.galinho.backend.model.Financeiro.PagamentoServico;
import com.galinho.backend.repository.Financeiro.FluxoFinanceiroRepository;
import com.galinho.backend.utils.TipoMovimentacao;

import jakarta.transaction.Transactional;

@Service
public class FluxoFinanceiroService {
    
    @Autowired
    private FluxoFinanceiroRepository fluxoRepository;

    @Autowired
    private FinanceiroMapper financeiroMapper;

    @Transactional
    public void registrarEntradaDePagamento(PagamentoServico pagamento, String tipoPagamento, String titulo) {
        FluxoFinanceiro fluxo = new FluxoFinanceiro();
        fluxo.setValor(pagamento.getValorFinal());
        fluxo.setTitulo(titulo);
        fluxo.setDescricao(pagamento.getServico().getDescricao() + " (" + tipoPagamento + ")");
        fluxo.setTipo(TipoMovimentacao.ENTRADA); 
        fluxo.setData(LocalDateTime.now());
        fluxo.setOrigemOuDestino("Serviço ID: " + pagamento.getServico().getId());        
        
        fluxoRepository.save(fluxo);
    }

    @Transactional
    public void registrarSaidaDePagamento(BigDecimal valorPago, String titulo, String descricao, String favorecido) {
        FluxoFinanceiro fluxo = new FluxoFinanceiro();
        fluxo.setValor(valorPago);
        fluxo.setTitulo(titulo);
        fluxo.setDescricao(descricao);
        fluxo.setTipo(TipoMovimentacao.SAIDA);
        fluxo.setData(LocalDateTime.now());
        fluxo.setOrigemOuDestino("Fornecedor/Destino: " + favorecido);

        fluxoRepository.save(fluxo);
    }

   public List<FluxoFinanceiroDto> listarFluxosDeEntrada() {
        return fluxoRepository.findAll().stream()
                .filter(f -> f.getTipo() == TipoMovimentacao.ENTRADA)
                .map(financeiroMapper::toFluxoFinanceiroDTO)
                .toList();
    }

    public List<FluxoFinanceiroDto> listarFluxosDeSaida() {
        return fluxoRepository.findAll().stream()
                .filter(f -> f.getTipo() == TipoMovimentacao.SAIDA)
                .map(financeiroMapper::toFluxoFinanceiroDTO)
                .toList();
    }

}