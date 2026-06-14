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

import com.galinho.backend.dto.Estoque.ProdutoCreate;
import com.galinho.backend.dto.Estoque.ProdutoDto;
import com.galinho.backend.service.Estoque.ProdutoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoDto> recuperarProdutos() {
        return produtoService.recuperarProdutos();
    }

    @GetMapping("/{id}")
    public ProdutoDto recuperarProdutoPorId(@PathVariable Long id) {
        return produtoService.recuperarProdutoPorId(id);
    }

    @PutMapping
    public ProdutoDto atualizarProduto(@RequestBody ProdutoDto produtoDto) {
        return produtoService.atualizarProduto(produtoDto);
    }

    @PostMapping
    public ProdutoDto criarProduto(@RequestBody ProdutoCreate produtoCreate) {
        return produtoService.criarProduto(produtoCreate);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }


}
