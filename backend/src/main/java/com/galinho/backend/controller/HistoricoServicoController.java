package com.galinho.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galinho.backend.dto.HistoricoServicoDto;
import com.galinho.backend.service.HistoricoServicoService;

@RestController
@RequestMapping("/historico")
@CrossOrigin("*")
public class HistoricoServicoController {
    @Autowired
    private HistoricoServicoService historicoServico;

    @GetMapping
    public List<HistoricoServicoDto> recuperarHistoricoServicos(){
        return historicoServico.recuperarHistoricoServicos();
    }

    @GetMapping("/servico/{idServico}")
    public List<HistoricoServicoDto> recuperarHistoricoServico(@PathVariable("idServico") long id){
        return historicoServico.recuperarHistoricoServico(id);
    }
}
