package com.galinho.backend.service.Estoque;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galinho.backend.dto.Estoque.FornecedorCreate;
import com.galinho.backend.dto.Estoque.FornecedorDto;
import com.galinho.backend.exception.EntidadeNaoEncontradaException;
import com.galinho.backend.mapper.Estoque.FornecedorMapper;
import com.galinho.backend.model.Estoque.Fornecedor;
import com.galinho.backend.repository.Estoque.FornecedorRepository;

import jakarta.transaction.Transactional;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private FornecedorMapper mapperFornecedor;

    public List<FornecedorDto> recuperarFornecedores(){
        List<Fornecedor> fornecedores = fornecedorRepository.recuperarFornecedores();
        return mapperFornecedor.toFornecedoresDto(fornecedores);
     }

     public FornecedorDto recuperarFornecedorPorId(Long id){
        Fornecedor fornecedor = fornecedorRepository.findById(id).orElseThrow(
            () -> new EntidadeNaoEncontradaException(
                "Fornecedor de id = " + id + " não encontrado."));
        return mapperFornecedor.toFornecedorDto(fornecedor);
     }

     @Transactional
     public FornecedorDto atualizarFornecedor(FornecedorDto fornecedorDto){
         Fornecedor fornecedor = mapperFornecedor.toFornecedor(fornecedorDto);
         fornecedor = fornecedorRepository.save(fornecedor);
         return mapperFornecedor.toFornecedorDto(fornecedor);
     }

     @Transactional
     public FornecedorDto cadastrarFornecedor(FornecedorCreate fornecedorCreate){
         Fornecedor fornecedor = mapperFornecedor.toFornecedor(fornecedorCreate);
         fornecedor = fornecedorRepository.save(fornecedor);
         return mapperFornecedor.toFornecedorDto(fornecedor);
     }

     public void deletarFornecedor(Long id){
        fornecedorRepository.deleteById(id);
     }
}
