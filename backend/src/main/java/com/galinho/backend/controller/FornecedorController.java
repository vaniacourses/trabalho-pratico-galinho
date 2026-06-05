package com.galinho.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galinho.backend.dto.FornecedorCreate;
import com.galinho.backend.dto.FornecedorDto;
import com.galinho.backend.service.FornecedorService;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public List<FornecedorDto> recuperarFornecedores() {
        return fornecedorService.recuperarFornecedores();
    }

    @GetMapping("/{id}")
    public FornecedorDto recuperarFornecedorPorId(@PathVariable Long id) {
        return fornecedorService.recuperarFornecedorPorId(id);
    }
    
    @PutMapping
    public FornecedorDto atualizarFornecedor(@RequestBody FornecedorDto fornecedorDto) {
        return fornecedorService.atualizarFornecedor(fornecedorDto);
    }

    @PostMapping
    public FornecedorDto cadastrarFornecedor(@RequestBody FornecedorCreate fornecedorCreate) {
        return fornecedorService.cadastrarFornecedor(fornecedorCreate);
    }

    @DeleteMapping("/{id}")
    public void deletarFornecedor(@PathVariable Long id) {
        fornecedorService.deletarFornecedor(id);
    }
}
