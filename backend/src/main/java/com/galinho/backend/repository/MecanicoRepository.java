package com.galinho.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.galinho.backend.model.Usuarios.Mecanico;

public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {

    Mecanico findByEmail(String email);

}
