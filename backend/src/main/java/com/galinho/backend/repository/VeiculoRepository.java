package com.galinho.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.galinho.backend.model.Servicos.Servico;
import com.galinho.backend.model.Servicos.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
    
}
