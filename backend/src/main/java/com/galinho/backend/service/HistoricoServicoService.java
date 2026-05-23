package com.galinho.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galinho.backend.dto.HistoricoServicoDto;
import com.galinho.backend.mapper.HistoricoServicoMapper;
import com.galinho.backend.model.Servicos.HistoricoServico;
import com.galinho.backend.repository.HistoricoServicoRepository;

@Service
public class HistoricoServicoService {
    @Autowired
    private HistoricoServicoRepository historicoServicoRepository;
    @Autowired
    private HistoricoServicoMapper historicoServicoMapper;

    public List<HistoricoServicoDto> recuperarHistoricoServicos(){
        List<HistoricoServico> historico = historicoServicoRepository.recuperarHistoricoServicos();
        return historicoServicoMapper.toHistoricoServicosDto(historico);
    }

}
