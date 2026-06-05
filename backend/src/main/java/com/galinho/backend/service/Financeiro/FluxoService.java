package com.galinho.backend.service.Financeiro;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galinho.backend.dto.Financeiro.FluxoFinanceiroCreate;
import com.galinho.backend.dto.Financeiro.FluxoFinanceiroDto;
import com.galinho.backend.exception.EntidadeNaoEncontradaException;
import com.galinho.backend.mapper.Financeiro.FinanceiroMapper;
import com.galinho.backend.model.Financeiro.FluxoFinanceiro;
import com.galinho.backend.repository.Financeiro.FluxoFinanceiroRepository;

import jakarta.transaction.Transactional;

@Service
public class FluxoService {
    @Autowired
    private FluxoFinanceiroRepository fluxoRepository;

    @Autowired
    private FinanceiroMapper financeiroMapper;

    @Transactional
    public FluxoFinanceiroDto gerarFluxo(FluxoFinanceiroCreate dto) {
        FluxoFinanceiro fluxo = new FluxoFinanceiro();
        fluxo.setValor(dto.valor());
        fluxo.setTitulo(dto.titulo());
        fluxo.setDescricao(dto.descricao());
        fluxo.setTipo(dto.tipo()); 
        fluxo.setData(LocalDateTime.now());
        fluxo.setOrigemOuDestino(dto.origemOuDestino());
        
        FluxoFinanceiro salvo = fluxoRepository.save(fluxo);
        return financeiroMapper.toFluxoFinanceiroDTO(salvo);
    }

    public FluxoFinanceiroDto buscarPorId(Long id) {
        FluxoFinanceiro fluxo = fluxoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Fluxo de id = " + id + " nao encontrado."));
        return financeiroMapper.toFluxoFinanceiroDTO(fluxo);
    }

    public List<FluxoFinanceiroDto> listarFluxos() {
        return fluxoRepository.findAll().stream()
                .map(financeiroMapper::toFluxoFinanceiroDTO)
                .toList();
    }

    @Transactional
    public void deletarFluxo(Long id) {
        if (!fluxoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Fluxo de id = " + id + " não encontrado.");
        }
        fluxoRepository.deleteById(id);
    }
}
