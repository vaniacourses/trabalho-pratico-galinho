package com.galinho.backend.controller.Usuario;

import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.galinho.backend.dto.Usuario.MecanicoRequest;
import com.galinho.backend.dto.Usuario.MecanicoResponse;
import com.galinho.backend.service.Usuario.MecanicoService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("mecanicos")
public class MecanicoController {

    @Autowired
    private MecanicoService mecanicoService;

    @GetMapping
    public List<MecanicoResponse> recuperarMecanicos() {
        return mecanicoService.recuperarMecanicos();
    }

    @GetMapping("{idMecanico}")
    public MecanicoResponse recuperarMecanicoPorId(@PathVariable("idMecanico") Long id) {
        return mecanicoService.recuperarMecanicoPorId(id);
    }

    public MecanicoResponse recuperarMecanicoPorEmail(String email) {
        return mecanicoService.recuperarMecanicoPorEmail(email);
    }

    @PostMapping
    public MecanicoResponse cadastraMecanicoa(@RequestBody @Validated({Default.class, MecanicoRequest.OnCreate.class}) MecanicoRequest mecanicoRequest) {
        return mecanicoService.cadastrarMecanico(mecanicoRequest);
    }

    @PutMapping
    public MecanicoResponse alterarMecanico(@RequestBody @Validated({Default.class, MecanicoRequest.OnUpdate.class}) MecanicoRequest mecanicoRequest) {
        return mecanicoService.alterarMecanico(mecanicoRequest);
    }

    @DeleteMapping("{idMecanico}")
    public void removerMecanicoPorId(@PathVariable("idMecanico") Long id) {
        mecanicoService.removerMecanicoPorId(id);
    }
}
