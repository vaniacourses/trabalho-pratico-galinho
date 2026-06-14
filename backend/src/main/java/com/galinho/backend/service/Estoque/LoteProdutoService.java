package com.galinho.backend.service.Estoque;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galinho.backend.dto.Estoque.LoteProdutoCreate;
import com.galinho.backend.dto.Estoque.LoteProdutoDto;
import com.galinho.backend.exception.EntidadeNaoEncontradaException;
import com.galinho.backend.mapper.Estoque.LoteProdutoMapper;
import com.galinho.backend.model.Estoque.Fornecedor;
import com.galinho.backend.model.Estoque.LoteProduto;
import com.galinho.backend.model.Estoque.Produto;
import com.galinho.backend.repository.Estoque.FornecedorRepository;
import com.galinho.backend.repository.Estoque.LoteProdutoRepository;
import com.galinho.backend.repository.Estoque.ProdutoRepository;

@Service
public class LoteProdutoService {
    @Autowired
    private LoteProdutoRepository loteProdutoRepository;
    @Autowired
    private FornecedorRepository fornecedorRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    

    @Autowired
    private LoteProdutoMapper loteProdutoMapper;

    public List<LoteProdutoDto> recuperarLotes(){
        List<LoteProduto> lotes = loteProdutoRepository.recuperarLotes();
        return loteProdutoMapper.toLotesProdutoDto(lotes);
    }

    public LoteProdutoDto recuperarLotePorId(long id){
        LoteProduto lote = loteProdutoRepository.findById(id).orElseThrow(
            () -> new EntidadeNaoEncontradaException(
                "Lote " + id + " não encontrado."));
        return loteProdutoMapper.toLoteProdutoDto(lote);
    }

    public List<LoteProdutoDto> recuperarLotesPorProduto(long idProduto){
        List<LoteProduto> lotes = loteProdutoRepository.recuperarLotesPorProduto(idProduto);
        return loteProdutoMapper.toLotesProdutoDto(lotes);
    }

    public LoteProdutoDto atualizarLote(LoteProdutoDto loteProdutoDto){
        LoteProduto lote = loteProdutoMapper.toLoteProduto(loteProdutoDto);
        lote = loteProdutoRepository.save(lote);
        return loteProdutoMapper.toLoteProdutoDto(lote);
    }

    public LoteProdutoDto cadastrarLote(LoteProdutoCreate loteProdutoCreate){
        Fornecedor fornecedor = fornecedorRepository.findById(loteProdutoCreate.fornecedorId()).orElseThrow( () -> new EntidadeNaoEncontradaException(
                "Lote não encontrado."));
        Produto produto = produtoRepository.findById(loteProdutoCreate.produtoId()).orElseThrow( () -> new EntidadeNaoEncontradaException(
                "Lote não encontrado."));
        LoteProduto lote = loteProdutoMapper.toLoteProduto(loteProdutoCreate);
        lote.setFornecedor(fornecedor);
        lote.setProduto(produto);
        lote = loteProdutoRepository.save(lote);
        return loteProdutoMapper.toLoteProdutoDto(lote);
    }
}
