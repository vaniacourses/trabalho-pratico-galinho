package com.galinho.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.galinho.backend.dto.ServicoCreate;
import com.galinho.backend.dto.ServicoDto;
import com.galinho.backend.exception.EntidadeNaoEncontradaException;
import com.galinho.backend.mapper.MapperServico;
import com.galinho.backend.model.Servicos.Servico;
import com.galinho.backend.repository.ServicoRepository;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private MapperServico mapperServico;

    public List<ServicoDto> recuperarServicos(){
        List<Servico> servicos = servicoRepository.recuperarServicos();
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

    public ServicoDto atualizarServico(ServicoDto servicoDto){
        Servico servico = mapperServico.toServico(servicoDto);
        servico = servicoRepository.save(servico);
        return mapperServico.toServicoDto(servico);
    }

    public ServicoDto cadastrarServico(ServicoCreate servicoCreate){
        Servico servico = mapperServico.toServico(servicoCreate);
        servico = servicoRepository.save(servico);
        return mapperServico.toServicoDto(servico);
    }
    
}
