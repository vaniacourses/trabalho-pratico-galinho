package com.galinho.backend.controller.Estoque;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galinho.backend.dto.Estoque.LoteProdutoCreate;
import com.galinho.backend.dto.Estoque.LoteProdutoDto;
import com.galinho.backend.service.Estoque.LoteProdutoService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/loteproduto")
public class LoteProdutoController {
    @Autowired
    private LoteProdutoService LoteProdutoService;

    @GetMapping
    public List<LoteProdutoDto> recuperarLotes(){
        return LoteProdutoService.recuperarLotes();
    }

    @GetMapping("{idLote}")
    public LoteProdutoDto recuperarLotePorId(@PathVariable("idLote") long id){
        return LoteProdutoService.recuperarLotePorId(id);
    }

    @GetMapping("/produto/{idProduto}")
    public List<LoteProdutoDto> recuperarLotesPorProduto(@PathVariable("idProduto") long idProduto){
        return LoteProdutoService.recuperarLotesPorProduto(idProduto);
    }

    @PutMapping
    public LoteProdutoDto atualizarLote(@RequestBody LoteProdutoDto loteProdutoDto){
        return LoteProdutoService.atualizarLote(loteProdutoDto);
    }

    @PostMapping
    public LoteProdutoDto cadastrarLote(@RequestBody @Valid LoteProdutoCreate loteProdutoCreate){
        return LoteProdutoService.cadastrarLote(loteProdutoCreate);
    }
}
