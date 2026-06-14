package com.galinho.backend.service.Veiculo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galinho.backend.dto.VeiculoCreate;
import com.galinho.backend.dto.VeiculoDto;
import com.galinho.backend.exception.EntidadeNaoEncontradaException;
import com.galinho.backend.mapper.Veiculo.MapperVeiculo;
import com.galinho.backend.model.Servicos.Veiculo;
import com.galinho.backend.model.Usuarios.Cliente;
import com.galinho.backend.repository.Usuario.ClienteRepository;
import com.galinho.backend.repository.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private MapperVeiculo MapperVeiculo;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<VeiculoDto> recuperarVeiculos(){
        List<Veiculo> veiculos = veiculoRepository.recuperarVeiculos();
        return MapperVeiculo.toVeiculosDto(veiculos);
    }

    public VeiculoDto recuperarVeiculo(long id){
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(
            () -> new EntidadeNaoEncontradaException(
                "Veículo de id = " + id + " não encontrado."));
        return MapperVeiculo.toVeiculoDto(veiculo);
    }

    public List<VeiculoDto> recuperarVeiculosDeCliente(long idCliente){
         List<Veiculo> veiculos = veiculoRepository.recuperarVeiculosPorCliente(idCliente);
         return MapperVeiculo.toVeiculosDto(veiculos);
    }

    public VeiculoDto recuperarVeiculoDeCliente(long idVeiculo, long idCliente){
        Veiculo veiculo = veiculoRepository.recuperarVeiculoDeCliente(idVeiculo, idCliente);
        return MapperVeiculo.toVeiculoDto(veiculo);
    }


    public VeiculoDto criarVeiculo(VeiculoCreate veiculoCreate) {


        Cliente cliente = clienteRepository.findById(
                veiculoCreate.Idcliente())
            .orElseThrow(() ->
                new RuntimeException("Cliente não encontrado"));

        
        Veiculo veiculo = MapperVeiculo.toVeiculo(veiculoCreate);

        veiculo.setCliente(cliente);


        Veiculo veiculoSalvo = veiculoRepository.save(veiculo);

        return MapperVeiculo.toVeiculoDto(veiculoSalvo);
    }

    public void deletarVeiculo(long id) {
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(
            () -> new EntidadeNaoEncontradaException(
                "Veículo de id = " + id + " não encontrado."));
        veiculoRepository.delete(veiculo);
    }

    public VeiculoDto atualizarVeiculo(VeiculoDto veiculoDto) {
        
        Veiculo veiculo = MapperVeiculo.toVeiculo(veiculoDto);
        Veiculo veiculoAtualizado = veiculoRepository.save(veiculo);

        return MapperVeiculo.toVeiculoDto(veiculoAtualizado);
    }
}
