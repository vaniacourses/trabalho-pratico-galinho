package com.galinho.backend.repository.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import com.galinho.backend.model.Usuarios.Gerente;

public interface GerenteRepository extends JpaRepository<Gerente, Long> {

    Gerente findByEmail(String email);

}
