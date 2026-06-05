package com.galinho.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galinho.backend.dto.VeiculoDto;
import com.galinho.backend.exception.EntidadeNaoEncontradaException;
import com.galinho.backend.mapper.MapperVeiculo;
import com.galinho.backend.model.Servicos.Veiculo;
import com.galinho.backend.repository.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private MapperVeiculo veiculoServico;

    public List<VeiculoDto> recuperarVeiculos(){
        List<Veiculo> veiculos = veiculoRepository.recuperarVeiculos();
        return veiculoServico.toVeiculosDto(veiculos);
    }

    public VeiculoDto recuperarVeiculo(long id){
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(
            () -> new EntidadeNaoEncontradaException(
                "Veículo de id = " + id + " não encontrado."));
        return veiculoServico.toVeiculoDto(veiculo);
    }

    public List<VeiculoDto> recuperarVeiculosDeCliente(long idCliente){
         List<Veiculo> veiculos = veiculoRepository.recuperarVeiculosPorCliente(idCliente);
         return veiculoServico.toVeiculosDto(veiculos);
    }

    public VeiculoDto recuperarVeiculoDeCliente(long idVeiculo, long idCliente){
        Veiculo veiculo = veiculoRepository.recuperarVeiculoDeCliente(idVeiculo, idCliente);
        return veiculoServico.toVeiculoDto(veiculo);
    }

}
