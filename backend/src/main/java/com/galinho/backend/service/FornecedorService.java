package com.galinho.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galinho.backend.dto.FornecedorCreate;
import com.galinho.backend.dto.FornecedorDto;
import com.galinho.backend.exception.EntidadeNaoEncontradaException;
import com.galinho.backend.mapper.MapperFornecedor;
import com.galinho.backend.model.Estoque.Fornecedor;
import com.galinho.backend.repository.FornecedorRepository;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private MapperFornecedor mapperFornecedor;

    public List<FornecedorDto> recuperarFornecedores(){
        return fornecedorRepository.recuperarFornecedores();
     }

     public FornecedorDto recuperarFornecedorPorId(Long id){
        Fornecedor fornecedor = fornecedorRepository.findById(id).orElseThrow(
            () -> new EntidadeNaoEncontradaException(
                "Fornecedor de id = " + id + " não encontrado."));
        return mapperFornecedor.toFornecedorDto(fornecedor);
     }

     public FornecedorDto atualizarFornecedor(FornecedorDto fornecedorDto){
         Fornecedor fornecedor = mapperFornecedor.toFornecedor(fornecedorDto);
         fornecedor = fornecedorRepository.save(fornecedor);
         return mapperFornecedor.toFornecedorDto(fornecedor);
     }

     public FornecedorDto cadastrarFornecedor(FornecedorCreate fornecedorCreate){
         Fornecedor fornecedor = mapperFornecedor.toFornecedor(fornecedorCreate);
         fornecedor = fornecedorRepository.save(fornecedor);
         return mapperFornecedor.toFornecedorDto(fornecedor);
     }

     public void deletarFornecedor(Long id){
        fornecedorRepository.deleteById(id);
     }
}
