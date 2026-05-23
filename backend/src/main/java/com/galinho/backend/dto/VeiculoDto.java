package com.galinho.backend.dto;

import com.galinho.backend.model.Servicos.Servico;
import com.galinho.backend.model.Usuarios.Cliente;

public class VeiculoDto {
    Long Id;
    String placa;
    String marca;
    String modelo;
    Integer ano;
    String cor;
    Servico servico;
    Cliente cliente;
}
