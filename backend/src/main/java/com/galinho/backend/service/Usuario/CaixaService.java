package com.galinho.backend.service.Usuario;

import com.galinho.backend.dto.Usuario.CaixaRequest;
import com.galinho.backend.dto.Usuario.CaixaResponse;
import com.galinho.backend.exception.EntidadeNaoEncontradaException;
import com.galinho.backend.factories.Usuario.CaixaFactory;
import com.galinho.backend.mapper.Usuario.CaixaMapper;
import com.galinho.backend.model.Usuarios.Caixa;
import com.galinho.backend.repository.Usuario.CaixaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CaixaService {

    @Autowired
    private CaixaRepository caixaRepository;

    @Autowired
    private CaixaMapper caixaMapper;

    @Autowired
    private CaixaFactory caixaFactory;

    public List<CaixaResponse> recuperarCaixas() {
        List<Caixa> caixas = caixaRepository.findAll();
        return caixaMapper.toCaixasResponse(caixas);
    }

    public CaixaResponse recuperarCaixaPorId(Long id) {
        Caixa caixa = caixaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Caixa com Id = " + id + " não encontrado."));
        return caixaMapper.toCaixaResponse(caixa);
    }

    public CaixaResponse recuperarCaixaPorEmail(String email) {
        Caixa caixa = caixaRepository.findByEmail(email);
        return caixaMapper.toCaixaResponse(caixa);
    }

    public CaixaResponse cadastrarCaixa(CaixaRequest caixaRequest) {
        if(recuperarCaixaPorEmail(caixaRequest.email()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email já cadastrado.");
        }
        String senhaCripto = new BCryptPasswordEncoder().encode(caixaRequest.senha());
        
        Caixa caixa = caixaFactory.criarUsuario();
        caixa.setEmail(caixaRequest.email());
        caixa.setSenha(senhaCripto);
        caixa.setNome(caixaRequest.nome());
        caixa.setCpf(caixaRequest.cpf());
        caixa.setTelefone(caixaRequest.telefone());
        
        caixa = caixaRepository.save(caixa);
        return caixaMapper.toCaixaResponse(caixa);
    }

    public CaixaResponse alterarCaixa(CaixaRequest caixaRequest) {
        Caixa caixa = caixaMapper.toCaixa(caixaRequest);
        caixa = caixaRepository.save(caixa);
        return caixaMapper.toCaixaResponse(caixa);
    }

    public void removerCaixaPorId(Long id) {
        recuperarCaixaPorId(id);
        caixaRepository.deleteById(id);
    }

}
