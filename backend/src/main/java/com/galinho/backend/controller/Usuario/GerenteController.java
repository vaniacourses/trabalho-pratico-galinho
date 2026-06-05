package com.galinho.backend.controller.Usuario;

import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.galinho.backend.dto.Usuario.GerenteRequest;
import com.galinho.backend.dto.Usuario.GerenteResponse;
import com.galinho.backend.service.Usuario.GerenteService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("gerentes")
public class GerenteController {

    @Autowired
    private GerenteService gerenteService;

    @GetMapping
    public List<GerenteResponse> recuperarGerentes() {
        return gerenteService.recuperarGerentes();
    }

    @GetMapping("{idGerente}")
    public GerenteResponse recuperarGerentePorId(@PathVariable("idGerente") Long id) {
        return gerenteService.recuperarGerentePorId(id);
    }

    public GerenteResponse recuperarGerentePorEmail(String email) {
        return gerenteService.recuperarGerentePorEmail(email);
    }

    @PostMapping
    public GerenteResponse cadastrarGerente(@RequestBody @Validated({Default.class, GerenteRequest.OnCreate.class}) GerenteRequest gerenteRequest) {
        return gerenteService.cadastrarGerente(gerenteRequest);
    }

    @PutMapping
    public GerenteResponse alterarGerente(@RequestBody @Validated({Default.class, GerenteRequest.OnUpdate.class}) GerenteRequest gerenteRequest) {
        return gerenteService.alterarGerente(gerenteRequest);
    }

    @DeleteMapping("{idGerente}")
    public void removerGerentePorId(@PathVariable("idGerente") Long id) {
        gerenteService.removerGerentePorId(id);
    }
}
