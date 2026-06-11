package com.galinho.backend.dto;

import com.galinho.backend.model.Servicos.Servico;
import com.galinho.backend.model.Usuarios.Cliente;

import jakarta.validation.constraints.Null;


public record VeiculoCreate (@Null Long Id,
    String placa,
    String marca,
    String modelo,
    Integer ano,
    String cor,
    Servico servico,
    Long Idcliente) {
    
}
