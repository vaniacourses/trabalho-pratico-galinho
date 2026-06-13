package com.galinho.backend.controller;

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

import com.galinho.backend.dto.ServicoCreate;
import com.galinho.backend.dto.ServicoDto;
import com.galinho.backend.dto.ServicoMecanicoDto;
import com.galinho.backend.service.ServicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/servicos")
@CrossOrigin("*")
public class ServicoController {
    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public List<ServicoDto> recuperarServicos(){
        return servicoService.recuperarServicos();
    }

    @GetMapping("EmProcesso")
    public List<ServicoDto> recuperarServicosEmProcesso(){
        return servicoService.recuperarServicosEmProcesso();
    }

    @GetMapping("{idServico}")
    public ServicoDto recuperarServico(@PathVariable("idServico") long id){
        return servicoService.recuperarServico(id);
    }

    @GetMapping("/cliente/{idCliente}")
    public List<ServicoDto> recuperarServicosDeCliente(@PathVariable("idCliente") long idCliente){
        return servicoService.recuperarServicosDeCliente(idCliente);
    }

    @GetMapping("{idServico}/{idCliente}")
    public ServicoDto recuperarServicoDeCliente(@PathVariable("idServico") long idServico, @PathVariable("idCliente") long idCliente){
        return servicoService.recuperarServicoDeCliente(idServico, idCliente);
    }
    
    @PutMapping
    public ServicoDto atualizarServico(@RequestBody ServicoDto servicoDto){
        return servicoService.atualizarServico(servicoDto);
    }

    // @PostMapping
    // public ServicoDto cadastrarServico(@RequestBody @Valid ServicoCreate servicoCreate){
    //     return servicoService.cadastrarServico(servicoCreate);
    // }

    @DeleteMapping("{idServico}")
    public void deletarServico(@PathVariable("idServico") long id){
        servicoService.deletarServico(id);
    }

    //MECANICOS
    @GetMapping("mecanico")
    public List<ServicoMecanicoDto> recuperarServicosMecanicos(){
        return servicoService.recuperarServicosMecanicos();
    }

    @GetMapping("mecanico/EmProcesso")
    public List<ServicoMecanicoDto> recuperarServicosMecanicosEmProcesso(){
        return servicoService.recuperarServicosMecanicosEmProcesso();
    }

    @GetMapping("mecanico/{idServico}")
    public ServicoMecanicoDto recuperarServicoMecanico(@PathVariable("idServico") long id){
        return servicoService.recuperarServicoMecanico(id);
    }
}