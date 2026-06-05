package com.galinho.backend.service.Estoque;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galinho.backend.dto.Estoque.ProdutoCreate;
import com.galinho.backend.dto.Estoque.ProdutoDto;
import com.galinho.backend.exception.EntidadeNaoEncontradaException;
import com.galinho.backend.mapper.Estoque.ProdutoMapper;
import com.galinho.backend.model.Estoque.Produto;
import com.galinho.backend.repository.Estoque.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoMapper mapperProduto;

    public List<ProdutoDto> recuperarProdutos() {
        List<Produto> produtos = produtoRepository.recuperarProdutos();
        return mapperProduto.toProdutosDto(produtos);
    }

    public  ProdutoDto recuperarProdutoPorId(Long id) {
         Produto produto = produtoRepository.findById(id).orElseThrow(
            () -> new EntidadeNaoEncontradaException(
                "Produto de id = " + id + " não encontrado."));
         return mapperProduto.toProdutoDto(produto);
    }

    public ProdutoDto atualizarProduto(ProdutoDto produtoDto) {
        Produto produto = mapperProduto.toProduto(produtoDto);
        produto = produtoRepository.save(produto);
        return mapperProduto.toProdutoDto(produto);
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
