package com.galinho.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galinho.backend.dto.VeiculoDto;
import com.galinho.backend.service.VeiculoService;


@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<VeiculoDto> recuperarVeiculos(){
        return veiculoService.recuperarVeiculos();
    }

    @GetMapping("{idVeiculo}")
    public VeiculoDto recuperarVeiculos(@PathVariable("idVeiculo") long id){
        return veiculoService.recuperarVeiculo(id);
    }

    @GetMapping("/cliente/{idCliente}")
    public List<VeiculoDto> recuperarVeiculosDeCliente(@PathVariable("idCliente") long idCliente){
        return veiculoService.recuperarVeiculosDeCliente(idCliente);
    }

    @GetMapping("{idVeiculo}/{idCliente}")
    public VeiculoDto recuperarVeiculoDeCliente(@PathVariable("idVeiculo") long idVeiculo, @PathVariable("idCliente") long idCliente){
        return veiculoService.recuperarVeiculoDeCliente(idVeiculo, idCliente);
    }

    @PostMapping("{idCliente}/{placa}")
    public VeiculoDto criarVeiculo(@PathVariable("idCliente") long idCliente, @PathVariable("placa") String placa){
        return veiculoService.criarVeiculo(idCliente, placa);
    }
}
