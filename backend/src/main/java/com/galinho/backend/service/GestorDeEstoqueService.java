package com.galinho.backend.service;

import com.galinho.backend.dto.GestorDeEstoqueRequest;
import com.galinho.backend.dto.GestorDeEstoqueResponse;
import com.galinho.backend.exception.EntidadeNaoEncontradaException;
import com.galinho.backend.factories.GestorDeEstoqueFactory;
import com.galinho.backend.mapper.GestorDeEstoqueMapper;
import com.galinho.backend.model.Usuarios.GestorDeEstoque;
import com.galinho.backend.repository.GestorDeEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GestorDeEstoqueService {

    @Autowired
    private GestorDeEstoqueRepository gestorDeEstoqueRepository;

    @Autowired
    private GestorDeEstoqueMapper gestorDeEstoqueMapper;

    @Autowired
    private GestorDeEstoqueFactory gestorDeEstoqueFactory;

    public List<GestorDeEstoqueResponse> recuperarGestorDeEstoques() {
        List<GestorDeEstoque> gestorDeEstoques = gestorDeEstoqueRepository.findAll();
        return gestorDeEstoqueMapper.toGestorDeEstoquesResponse(gestorDeEstoques);
    }

    public GestorDeEstoqueResponse recuperarGestorDeEstoquePorId(Long id) {
        GestorDeEstoque gestorDeEstoque = gestorDeEstoqueRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Gestor de Estoque com Id = " + id + " não encontrado."));
        return gestorDeEstoqueMapper.toGestorDeEstoqueResponse(gestorDeEstoque);
    }

    public GestorDeEstoqueResponse recuperarGestorDeEstoquePorEmail(String email) {
        GestorDeEstoque gestorDeEstoque = gestorDeEstoqueRepository.findByEmail(email);
        return gestorDeEstoqueMapper.toGestorDeEstoqueResponse(gestorDeEstoque);
    }

    public GestorDeEstoqueResponse cadastrarGestorDeEstoque(GestorDeEstoqueRequest gestorDeEstoqueRequest) {
        if(recuperarGestorDeEstoquePorEmail(gestorDeEstoqueRequest.email()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email já cadastrado.");
        }
        String senhaCripto = new BCryptPasswordEncoder().encode(gestorDeEstoqueRequest.senha());
        
        GestorDeEstoque gestorDeEstoque = gestorDeEstoqueFactory.criarUsuario();
        gestorDeEstoque.setEmail(gestorDeEstoqueRequest.email());
        gestorDeEstoque.setSenha(senhaCripto);
        gestorDeEstoque.setNome(gestorDeEstoqueRequest.nome());
        gestorDeEstoque.setCpf(gestorDeEstoqueRequest.cpf());
        gestorDeEstoque.setTelefone(gestorDeEstoqueRequest.telefone());
        
        gestorDeEstoque = gestorDeEstoqueRepository.save(gestorDeEstoque);
        return gestorDeEstoqueMapper.toGestorDeEstoqueResponse(gestorDeEstoque);
    }

    public GestorDeEstoqueResponse alterarGestorDeEstoque(GestorDeEstoqueRequest gestorDeEstoqueRequest) {
        GestorDeEstoque gestorDeEstoque = gestorDeEstoqueMapper.toGestorDeEstoque(gestorDeEstoqueRequest);
        gestorDeEstoque = gestorDeEstoqueRepository.save(gestorDeEstoque);
        return gestorDeEstoqueMapper.toGestorDeEstoqueResponse(gestorDeEstoque);
    }

    public void removerGestorDeEstoquePorId(Long id) {
        recuperarGestorDeEstoquePorId(id);
        gestorDeEstoqueRepository.deleteById(id);
    }
}
