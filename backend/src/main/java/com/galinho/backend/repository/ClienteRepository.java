package com.galinho.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.galinho.backend.model.Usuarios.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
