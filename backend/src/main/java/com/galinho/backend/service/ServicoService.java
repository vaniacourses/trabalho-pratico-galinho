package com.galinho.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.galinho.backend.dto.ServicoCreate;
import com.galinho.backend.dto.ServicoDto;
import com.galinho.backend.dto.ServicoMecanicoDto;
import com.galinho.backend.exception.EntidadeNaoEncontradaException;
import com.galinho.backend.mapper.ServicoMapper;
import com.galinho.backend.model.Servicos.HistoricoServico;
import com.galinho.backend.model.Servicos.Servico;
import com.galinho.backend.model.Servicos.Veiculo;
import com.galinho.backend.repository.HistoricoServicoRepository;
import com.galinho.backend.repository.ServicoRepository;
import com.galinho.backend.repository.VeiculoRepository;
import com.galinho.backend.utils.ServicoComparator;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;
    @Autowired
    private HistoricoServicoRepository historicoServicoRepository;
    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ServicoMapper mapperServico;

    public List<ServicoDto> recuperarServicos(){
        List<Servico> servicos = servicoRepository.recuperarServicos();
        return mapperServico.toServicosDto(servicos);
    }

    public List<ServicoDto> recuperarServicosEmProcesso(){
        List<Servico> servicos = servicoRepository.recuperarServicosEmProcesso();
        return mapperServico.toServicosDto(servicos);
    }

    public ServicoDto recuperarServico(long id){
        Servico servico = servicoRepository.findById(id).orElseThrow(
            () -> new EntidadeNaoEncontradaException(
                "Serviço de id = " + id + " não encontrado."));
        return mapperServico.toServicoDto(servico);
    }

    public List<ServicoDto> recuperarServicosDeCliente(long idCliente){
         List<Servico> servicos = servicoRepository.recuperarServicosDeCliente(idCliente);
         return mapperServico.toServicosDto(servicos);
    }

    public ServicoDto recuperarServicoDeCliente(long idServico, long idCliente){
        Servico servico = servicoRepository.recuperarServicoDeCliente(idServico, idCliente);
        return mapperServico.toServicoDto(servico);
    }

    // Usado em cadastrarServico e atualizarServico
    public void cadastrarHistoricoServico(Servico servico){
        HistoricoServico hist = new HistoricoServico(servico.getStatus(), servico.getOrcamento(), servico, servico.getDescricao());
        historicoServicoRepository.save(hist);
    }

    public ServicoDto atualizarServico(ServicoDto servicoDto){
        Servico servico = mapperServico.toServico(servicoDto);
        Servico servicoAtual = servicoRepository.findById(servico.getId())
            .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        boolean mudou = ServicoComparator.houveMudanca(servicoAtual, servico);
        servico = servicoRepository.save(servico);
        if(mudou){cadastrarHistoricoServico(servico);}
        return mapperServico.toServicoDto(servico);
    }

    public ServicoDto cadastrarServico(ServicoCreate servicoCreate){
        Servico servico = mapperServico.toServico(servicoCreate);
        // Veiculo veiculo = veiculoRepository.findById(servicoCreate.veiculoId())
        //     .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
        Veiculo veiculo = veiculoRepository.findByPlaca(servicoCreate.veiculoPlaca())
            .orElseThrow(() -> new RuntimeException(
            "Veículo com placa " + servicoCreate.veiculoPlaca() + " não encontrado"
        ));
        servico.setVeiculo(veiculo);
        servico = servicoRepository.save(servico);
        cadastrarHistoricoServico(servico);
        return mapperServico.toServicoDto(servico);
    }

    public void deletarServico(long id){
        servicoRepository.deleteById(id);;
    }


    //MECANICOS
    public List<ServicoMecanicoDto> recuperarServicosMecanicos(){
        List<Servico> servicos = servicoRepository.recuperarServicos();
        return mapperServico.toServicosMecanicosDto(servicos);
    }

    public List<ServicoMecanicoDto> recuperarServicosMecanicosEmProcesso(){
        List<Servico> servicos = servicoRepository.recuperarServicosEmProcesso();
        return mapperServico.toServicosMecanicosDto(servicos);
    }

    public ServicoMecanicoDto recuperarServicoMecanico(long id){
        Servico servico = servicoRepository.recuperarServicosPorId(id);
        return mapperServico.toServicoMecanicoDto(servico);
    }
}
