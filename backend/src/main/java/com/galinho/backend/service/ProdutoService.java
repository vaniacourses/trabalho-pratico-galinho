package com.galinho.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galinho.backend.dto.ProdutoCreate;
import com.galinho.backend.dto.ProdutoDto;
import com.galinho.backend.exception.EntidadeNaoEncontradaException;
import com.galinho.backend.mapper.MapperProduto;
import com.galinho.backend.model.Estoque.Produto;
import com.galinho.backend.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private MapperProduto mapperProduto;

    public ProdutoDto recuperarProdutos() {
        return produtoRepository.recuperarProdutos();
    }

    public  ProdutoDto recuperarProdutoPorId(Long id) {
         Produto produto = produtoRepository.findById(id).orElseThrow(
            () -> new EntidadeNaoEncontradaException(
                "Produto de id = " + id + " não encontrado."));
         return mapperProduto.toProdutoDto(produto);
    }

    public ProdutoDto atualizarProduto(ProdutoDto produtoDto) {
        Produto produto = mapperProduto.toProduto(produtoDto);
        return mapperProduto.toProdutoDto(produtoRepository.save(produto));
    }

    public ProdutoDto criarProduto(ProdutoCreate produtoCreate) {
        Produto produto = mapperProduto.toProduto(produtoCreate);
        produto = produtoRepository.save(produto);
        return mapperProduto.toProdutoDto(produto);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }

}
