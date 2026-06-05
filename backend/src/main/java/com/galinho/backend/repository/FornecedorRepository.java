package com.galinho.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.galinho.backend.model.Estoque.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    @Query("select f from Fornecedor f left join fetch f.produtos order by f.id")
    List<Fornecedor> recuperarFornecedores();
}
