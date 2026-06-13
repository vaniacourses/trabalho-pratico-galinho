package com.galinho.backend.repository.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import com.galinho.backend.model.Usuarios.GestorDeEstoque;

public interface GestorDeEstoqueRepository extends JpaRepository<GestorDeEstoque, Long> {

    GestorDeEstoque findByEmail(String email);

}
