package com.galinho.backend.service.Usuario;

import com.galinho.backend.dto.Usuario.MecanicoRequest;
import com.galinho.backend.dto.Usuario.MecanicoResponse;
import com.galinho.backend.exception.EntidadeNaoEncontradaException;
import com.galinho.backend.factories.Usuario.MecanicoFactory;
import com.galinho.backend.mapper.Usuario.MecanicoMapper;
import com.galinho.backend.model.Usuarios.Mecanico;
import com.galinho.backend.repository.Usuario.MecanicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MecanicoService {

    @Autowired
    private MecanicoRepository mecanicoRepository;

    @Autowired
    private MecanicoMapper mecanicoMapper;

    @Autowired
    private MecanicoFactory mecanicoFactory;

    public List<MecanicoResponse> recuperarMecanicos() {
        List<Mecanico> mecanicos = mecanicoRepository.findAll();
        return mecanicoMapper.toMecanicosResponse(mecanicos);
    }

    public MecanicoResponse recuperarMecanicoPorId(Long id) {
        Mecanico mecanico = mecanicoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Mecânico com Id = " + id + " não encontrado."));
        return mecanicoMapper.toMecanicoResponse(mecanico);
    }

    public MecanicoResponse recuperarMecanicoPorEmail(String email) {
        Mecanico mecanico = mecanicoRepository.findByEmail(email);
        return mecanicoMapper.toMecanicoResponse(mecanico);
    }

    public MecanicoResponse cadastrarMecanico(MecanicoRequest mecanicoRequest) {
        if(recuperarMecanicoPorEmail(mecanicoRequest.email()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email já cadastrado.");
        }
        String senhaCripto = new BCryptPasswordEncoder().encode(mecanicoRequest.senha());
        
        Mecanico mecanico = mecanicoFactory.criarUsuario();
        mecanico.setEmail(mecanicoRequest.email());
        mecanico.setSenha(senhaCripto);
        mecanico.setNome(mecanicoRequest.nome());
        mecanico.setCpf(mecanicoRequest.cpf());
        mecanico.setTelefone(mecanicoRequest.telefone());
        mecanico.setHabilidades(mecanicoRequest.habilidades());
        
        mecanico = mecanicoRepository.save(mecanico);
        return mecanicoMapper.toMecanicoResponse(mecanico);
    }

    public MecanicoResponse alterarMecanico(MecanicoRequest mecanicoRequest) {
        Mecanico mecanico = mecanicoMapper.toMecanico(mecanicoRequest);
        mecanico = mecanicoRepository.save(mecanico);
        return mecanicoMapper.toMecanicoResponse(mecanico);
    }

    public void removerMecanicoPorId(Long id) {
        recuperarMecanicoPorId(id);
        mecanicoRepository.deleteById(id);
    }
}
