package com.galinho.backend.service.Estoque;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galinho.backend.dto.Estoque.MovimentacaoEstoqueCreate;
import com.galinho.backend.dto.Estoque.MovimentacaoEstoqueDto;
import com.galinho.backend.exception.EntidadeNaoEncontradaException;
import com.galinho.backend.mapper.Estoque.MovimentacaoEstoqueMapper;
import com.galinho.backend.model.Estoque.MovimentacaoEstoque;
import com.galinho.backend.repository.Estoque.MovimentacaoEstoqueRepository;

@Service
public class MovimentacaoEstoqueService {
    @Autowired
    private MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

    @Autowired
    private MovimentacaoEstoqueMapper movimentacaoEstoqueMapper;

    public List<MovimentacaoEstoqueDto> recuperarMovimentacoes(){
        List<MovimentacaoEstoque> movimentacoes = movimentacaoEstoqueRepository.recuperarMovimentacoes();
        return movimentacaoEstoqueMapper.toMovimentacoesDto(movimentacoes);
    }

    public MovimentacaoEstoqueDto recuperarMovimentacaoPorId(long id){
        MovimentacaoEstoque movimentacao = movimentacaoEstoqueRepository.findById(id).orElseThrow(
            () -> new EntidadeNaoEncontradaException(
                "Movimentação " + id + " não encontrada."));
        return movimentacaoEstoqueMapper.toMovimentacaoEstoqueDto(movimentacao);
    }

    public List<MovimentacaoEstoqueDto> recuperarMovimentacoesPorProduto(long idProduto){
        List<MovimentacaoEstoque> movimentacoes = movimentacaoEstoqueRepository.recuperarMovimentacoesPorProduto(idProduto);
        return movimentacaoEstoqueMapper.toMovimentacoesDto(movimentacoes);
    }

    public MovimentacaoEstoqueDto atualizarMovimentacao(MovimentacaoEstoqueDto movimentacaoEstoqueDto){
        MovimentacaoEstoque movimentacao = movimentacaoEstoqueMapper.toMovimentacaoEstoque(movimentacaoEstoqueDto);
        movimentacao = movimentacaoEstoqueRepository.save(movimentacao);
        return movimentacaoEstoqueMapper.toMovimentacaoEstoqueDto(movimentacao);
    }

    public MovimentacaoEstoqueDto cadastrarMovimentacao(MovimentacaoEstoqueCreate movimentacaoEstoqueCreate){
        MovimentacaoEstoque movimentacao = movimentacaoEstoqueMapper.toMovimentacaoEstoque(movimentacaoEstoqueCreate);
        movimentacao = movimentacaoEstoqueRepository.save(movimentacao);
        return movimentacaoEstoqueMapper.toMovimentacaoEstoqueDto(movimentacao);
    }
}
