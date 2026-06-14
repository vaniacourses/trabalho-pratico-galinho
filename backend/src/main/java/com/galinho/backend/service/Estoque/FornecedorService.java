package com.galinho.backend.service.Estoque;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galinho.backend.dto.Estoque.FornecedorCreate;
import com.galinho.backend.dto.Estoque.FornecedorDto;
import com.galinho.backend.dto.Estoque.ProdutoDto;
import com.galinho.backend.exception.EntidadeNaoEncontradaException;
import com.galinho.backend.mapper.Estoque.FornecedorMapper;
import com.galinho.backend.mapper.Estoque.ProdutoMapper;
import com.galinho.backend.model.Estoque.Fornecedor;
import com.galinho.backend.model.Estoque.Produto;
import com.galinho.backend.repository.Estoque.FornecedorRepository;

import jakarta.transaction.Transactional;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private FornecedorMapper fornecedorMapper;

    @Autowired
    private ProdutoService produtoService;
    
    @Autowired
    private ProdutoMapper produtoMapper;

    public List<FornecedorDto> recuperarFornecedores(){
        List<Fornecedor> fornecedores = fornecedorRepository.recuperarFornecedores();
        return fornecedorMapper.toFornecedoresDto(fornecedores);
     }

     public FornecedorDto recuperarFornecedorPorId(Long id){
        Fornecedor fornecedor = fornecedorRepository.findById(id).orElseThrow(
            () -> new EntidadeNaoEncontradaException(
                "Fornecedor de id = " + id + " não encontrado."));
        return fornecedorMapper.toFornecedorDto(fornecedor);
     }

    public Fornecedor recuperarFornecedorComProdutosPorId(Long id){
        Fornecedor fornecedor = fornecedorRepository.recuperarFornecedorComProdutosPorId(id);
        return fornecedor;
    }

     @Transactional
     public FornecedorDto atualizarFornecedor(FornecedorDto fornecedorDto){
         Fornecedor fornecedor = fornecedorMapper.toFornecedor(fornecedorDto);
         fornecedor = fornecedorRepository.save(fornecedor);
         return fornecedorMapper.toFornecedorDto(fornecedor);
     }

     public Fornecedor adicionarProdutoDoFornecedor(Long id, Long idProduto){
        ProdutoDto produtoDto = produtoService.recuperarProdutoPorId(idProduto);
        Produto produto = produtoMapper.toProduto(produtoDto);
        Fornecedor fornecedor = recuperarFornecedorComProdutosPorId(id);
        fornecedor.adicionarProduto(produto);
        return fornecedorRepository.save(fornecedor);
     }

      public Fornecedor removerProdutoDoFornecedor(Long id, Long idProduto){
        ProdutoDto produtoDto = produtoService.recuperarProdutoPorId(idProduto);
        Produto produto = produtoMapper.toProduto(produtoDto);
        Fornecedor fornecedor = recuperarFornecedorComProdutosPorId(id);
        fornecedor.removerProduto(produto);
        return fornecedorRepository.save(fornecedor);
     }

     @Transactional
     public FornecedorDto cadastrarFornecedor(FornecedorCreate fornecedorCreate){
         Fornecedor fornecedor = fornecedorMapper.toFornecedor(fornecedorCreate);
         fornecedor = fornecedorRepository.save(fornecedor);
         return fornecedorMapper.toFornecedorDto(fornecedor);
     }

     public void deletarFornecedor(Long id){
        fornecedorRepository.deleteById(id);
     }
}

