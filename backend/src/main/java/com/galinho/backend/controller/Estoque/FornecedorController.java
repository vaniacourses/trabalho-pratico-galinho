package com.galinho.backend.controller.Estoque;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galinho.backend.dto.Estoque.FornecedorCreate;
import com.galinho.backend.dto.Estoque.FornecedorDto;
import com.galinho.backend.model.Estoque.Fornecedor;
import com.galinho.backend.service.Estoque.FornecedorService;

@CrossOrigin("*")
@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public List<FornecedorDto> recuperarFornecedores() {
        return fornecedorService.recuperarFornecedores();
    }

    @GetMapping("/{id}")
    public FornecedorDto recuperarFornecedorPorId(@PathVariable Long id) {
        return fornecedorService.recuperarFornecedorPorId(id);
    }

    @GetMapping("/{id}/produtos")
    public Fornecedor recuperarFornecedorComProdutosPorId(@PathVariable Long id) {
        return fornecedorService.recuperarFornecedorComProdutosPorId(id);
    }
    
    @PutMapping
    public FornecedorDto atualizarFornecedor(@RequestBody FornecedorDto fornecedorDto) {
        return fornecedorService.atualizarFornecedor(fornecedorDto);
    }

    @PutMapping("/{id}/adicionar-produto/{idProduto}")
    public Fornecedor adicionarProdutoDoFornecedor(@PathVariable Long id, @PathVariable Long idProduto) {
        return fornecedorService.adicionarProdutoDoFornecedor(id, idProduto);
    }

    @PutMapping("/{id}/remover-produto/{idProduto}")
    public Fornecedor removerProdutoDoFornecedor(@PathVariable Long id, @PathVariable Long idProduto) {
        return fornecedorService.removerProdutoDoFornecedor(id, idProduto);
    }

    @PostMapping
    public FornecedorDto cadastrarFornecedor(@RequestBody FornecedorCreate fornecedorCreate) {
        return fornecedorService.cadastrarFornecedor(fornecedorCreate);
    }

    @DeleteMapping("/{id}")
    public void deletarFornecedor(@PathVariable Long id) {
        fornecedorService.deletarFornecedor(id);
    }
}
