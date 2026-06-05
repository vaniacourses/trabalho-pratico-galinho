package com.galinho.backend.controller;

import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.galinho.backend.dto.GestorDeEstoqueRequest;
import com.galinho.backend.dto.GestorDeEstoqueResponse;
import com.galinho.backend.service.GestorDeEstoqueService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("gestores")
public class GestorDeEstoqueController {

    @Autowired
    private GestorDeEstoqueService gestorDeEstoqueService;

    @GetMapping
    public List<GestorDeEstoqueResponse> recuperarGestorDeEstoques() {
        return gestorDeEstoqueService.recuperarGestorDeEstoques();
    }

    @GetMapping("{idGestorDeEstoque}")
    public GestorDeEstoqueResponse recuperarGestorDeEstoquePorId(@PathVariable("idGestorDeEstoque") Long id) {
        return gestorDeEstoqueService.recuperarGestorDeEstoquePorId(id);
    }

    public GestorDeEstoqueResponse recuperarGestorDeEstoquePorEmail(String email) {
        return gestorDeEstoqueService.recuperarGestorDeEstoquePorEmail(email);
    }

    @PostMapping
    public GestorDeEstoqueResponse cadastrarGestorDeEstoque(@RequestBody @Validated({Default.class, GestorDeEstoqueRequest.OnCreate.class}) GestorDeEstoqueRequest gestorDeEstoqueRequest) {
        return gestorDeEstoqueService.cadastrarGestorDeEstoque(gestorDeEstoqueRequest);
    }

    @PutMapping
    public GestorDeEstoqueResponse alterarGestorDeEstoque(@RequestBody @Validated({Default.class, GestorDeEstoqueRequest.OnUpdate.class}) GestorDeEstoqueRequest gestorDeEstoqueRequest) {
        return gestorDeEstoqueService.alterarGestorDeEstoque(gestorDeEstoqueRequest);
    }

    @DeleteMapping("{idGestorDeEstoque}")
    public void removerGestorDeEstoquePorId(@PathVariable("idGestorDeEstoque") Long id) {
        gestorDeEstoqueService.removerGestorDeEstoquePorId(id);
    }
}
