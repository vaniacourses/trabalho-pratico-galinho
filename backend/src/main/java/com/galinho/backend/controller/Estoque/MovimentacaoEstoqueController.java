package com.galinho.backend.controller.Estoque;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galinho.backend.dto.Estoque.MovimentacaoEstoqueCreate;
import com.galinho.backend.dto.Estoque.MovimentacaoEstoqueDto;
import com.galinho.backend.service.Estoque.MovimentacaoEstoqueService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/movimentacaoestoque")
public class MovimentacaoEstoqueController {
    @Autowired
    private MovimentacaoEstoqueService movimentacaoEstoqueService;

    @GetMapping
    public List<MovimentacaoEstoqueDto> recuperarMovimentacoes(){
        return movimentacaoEstoqueService.recuperarMovimentacoes();
    }

    @GetMapping("{idMovimentacao}")
    public MovimentacaoEstoqueDto recuperarMovimentacaoPorId(@PathVariable("idMovimentacao") long id){
        return movimentacaoEstoqueService.recuperarMovimentacaoPorId(id);
    }

    @GetMapping("/produto/{idProduto}")
    public List<MovimentacaoEstoqueDto> recuperarMovimentacoesPorProduto(@PathVariable("idProduto") long idProduto){
        return movimentacaoEstoqueService.recuperarMovimentacoesPorProduto(idProduto);
    }

    @PutMapping
    public MovimentacaoEstoqueDto atualizarMovimentacao(@RequestBody MovimentacaoEstoqueDto movimentacaoEstoqueDto){
        return movimentacaoEstoqueService.atualizarMovimentacao(movimentacaoEstoqueDto);
    }

    @PostMapping
    public MovimentacaoEstoqueDto cadastrarMovimentacao(@RequestBody @Valid MovimentacaoEstoqueCreate movimentacaoEstoqueCreate){
        return movimentacaoEstoqueService.cadastrarMovimentacao(movimentacaoEstoqueCreate);
    }
}
