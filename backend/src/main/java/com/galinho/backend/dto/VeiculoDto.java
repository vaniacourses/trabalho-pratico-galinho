package com.galinho.backend.dto;

import com.galinho.backend.model.Servicos.Servico;
import com.galinho.backend.model.Usuarios.Cliente;

public record VeiculoDto(Long id, 
                        String placa, 
                        Cliente cliente, 
                        String marca, 
                        String modelo, 
                        String ano, 
                        String cor) {
   
}
