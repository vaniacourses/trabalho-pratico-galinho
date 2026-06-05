package com.galinho.backend.controller;

import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.galinho.backend.dto.CaixaRequest;
import com.galinho.backend.dto.CaixaResponse;
import com.galinho.backend.service.CaixaService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("caixas")
public class CaixaController {

    @Autowired
    private CaixaService caixaService;

    @GetMapping
    public List<CaixaResponse> recuperarCaixas() {
        return caixaService.recuperarCaixas();
    }

    @GetMapping("{idCaixa}")
    public CaixaResponse recuperarCaixaPorId(@PathVariable("idCaixa") Long id) {
        return caixaService.recuperarCaixaPorId(id);
    }

    public CaixaResponse recuperarCaixaPorEmail(String email) {
        return caixaService.recuperarCaixaPorEmail(email);
    }

    @PostMapping
    public CaixaResponse cadastrarCaixa(@RequestBody @Validated({Default.class, CaixaRequest.OnCreate.class}) CaixaRequest caixaRequest) {
        return caixaService.cadastrarCaixa(caixaRequest);
    }

    @PutMapping
    public CaixaResponse alterarCaixa(@RequestBody @Validated({Default.class, CaixaRequest.OnUpdate.class}) CaixaRequest caixaRequest) {
        return caixaService.alterarCaixa(caixaRequest);
    }

    @DeleteMapping("{idCaixa}")
    public void removerCaixaPorId(@PathVariable("idCaixa") Long id) {
        caixaService.removerCaixaPorId(id);
    }
}
