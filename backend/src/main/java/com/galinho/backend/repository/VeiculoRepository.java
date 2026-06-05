package com.galinho.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.galinho.backend.model.Servicos.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
    
    Optional<Veiculo> findByPlaca(String placa);
}
