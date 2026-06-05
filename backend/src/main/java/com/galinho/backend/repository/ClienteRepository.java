package com.galinho.backend.repository;

import com.galinho.backend.model.Usuarios.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByEmail(String email);

}
