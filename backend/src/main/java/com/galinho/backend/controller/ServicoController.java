package com.galinho.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galinho.backend.dto.ServicoCreate;
import com.galinho.backend.dto.ServicoDto;
import com.galinho.backend.service.ServicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/servicos")
public class ServicoController {
    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public List<ServicoDto> recuperarServicos(){
        return servicoService.recuperarServicos();
    }

    @GetMapping("{id}")
    public ServicoDto recuperarServicos(@PathVariable("id") long id){
        return servicoService.recuperarServico(id);
    }
    
    @PutMapping
    public ServicoDto atualizarServico(@RequestBody ServicoDto servicoDto){
        return servicoService.atualizarServico(servicoDto);
    }

    @PostMapping
    public ServicoDto cadastrarServico(@RequestBody @Valid ServicoCreate servicoCreate){
        return servicoService.cadastrarServico(servicoCreate);
    }

}