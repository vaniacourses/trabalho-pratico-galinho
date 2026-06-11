package com.galinho.backend.controller.Veiculo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.galinho.backend.dto.VeiculoCreate;
import com.galinho.backend.dto.VeiculoDto;
import com.galinho.backend.service.Veiculo.VeiculoService;


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

    @PostMapping
        public VeiculoDto criarVeiculo(@RequestBody VeiculoCreate veiculoCreate){
        return veiculoService.criarVeiculo(veiculoCreate);
    }

    @DeleteMapping("{idVeiculo}")
    public void deletarVeiculo(@PathVariable("idVeiculo") long id){
        veiculoService.deletarVeiculo(id);  
    }
    
    @PutMapping
    public VeiculoDto atualizarVeiculo(@RequestBody VeiculoDto veiculoDto){
        return veiculoService.atualizarVeiculo(veiculoDto);
    }
}
