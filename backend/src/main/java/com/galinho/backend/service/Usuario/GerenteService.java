package com.galinho.backend.service.Usuario;

import com.galinho.backend.dto.Usuario.GerenteRequest;
import com.galinho.backend.dto.Usuario.GerenteResponse;
import com.galinho.backend.exception.EntidadeNaoEncontradaException;
import com.galinho.backend.factories.Usuario.GerenteFactory;
import com.galinho.backend.mapper.Usuario.GerenteMapper;
import com.galinho.backend.model.Usuarios.Gerente;
import com.galinho.backend.repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GerenteService {

    @Autowired
    private GerenteRepository gerenteRepository;

    @Autowired
    private GerenteMapper gerenteMapper;

    @Autowired
    private GerenteFactory gerenteFactory;

    public List<GerenteResponse> recuperarGerentes() {
        List<Gerente> gerentes = gerenteRepository.findAll();
        return gerenteMapper.toGerentesResponse(gerentes);
    }

    public GerenteResponse recuperarGerentePorId(Long id) {
        Gerente gerente = gerenteRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Gerente com Id = " + id + " não encontrado."));
        return gerenteMapper.toGerenteResponse(gerente);
    }

    public GerenteResponse recuperarGerentePorEmail(String email) {
        Gerente gerente = gerenteRepository.findByEmail(email);
        return gerenteMapper.toGerenteResponse(gerente);
    }

    public GerenteResponse cadastrarGerente(GerenteRequest gerenteRequest) {
        if(recuperarGerentePorEmail(gerenteRequest.email()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email já cadastrado.");
        }
        String senhaCripto = new BCryptPasswordEncoder().encode(gerenteRequest.senha());
        
        Gerente gerente = gerenteFactory.criarUsuario();
        gerente.setEmail(gerenteRequest.email());
        gerente.setSenha(senhaCripto);
        gerente.setNome(gerenteRequest.nome());
        gerente.setCpf(gerenteRequest.cpf());
        gerente.setTelefone(gerenteRequest.telefone());
        
        gerente = gerenteRepository.save(gerente);
        return gerenteMapper.toGerenteResponse(gerente);
    }

    public GerenteResponse alterarGerente(GerenteRequest gerenteRequest) {
        Gerente gerente = gerenteMapper.toGerente(gerenteRequest);
        gerente = gerenteRepository.save(gerente);
        return gerenteMapper.toGerenteResponse(gerente);
    }

    public void removerGerentePorId(Long id) {
        recuperarGerentePorId(id);
        gerenteRepository.deleteById(id);
    }

}
