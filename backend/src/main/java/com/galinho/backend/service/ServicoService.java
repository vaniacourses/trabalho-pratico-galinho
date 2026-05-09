package com.galinho.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.galinho.backend.dto.ServicoCreate;
import com.galinho.backend.dto.ServicoDto;
import com.galinho.backend.exception.EntidadeNaoEncontradaException;
import com.galinho.backend.mapper.MapperServico;
import com.galinho.backend.model.Servicos.Servico;
import com.galinho.backend.repository.ServicoRepository;

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
