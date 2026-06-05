package com.galinho.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.galinho.backend.model.Usuarios.Caixa;

public interface CaixaRepository extends JpaRepository<Caixa, Long> {

    Caixa findByEmail(String email);

}
