package com.galinho.backend.repository.Estoque;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.galinho.backend.model.Estoque.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    @Query("select f from Fornecedor f left join fetch f.produtos order by f.id")
    List<Fornecedor> recuperarFornecedores();

    @Query("select f from Fornecedor f left join fetch f.produtos where f.id = :id order by f.id")
    Fornecedor recuperarFornecedorComProdutosPorId(@Param("id") long id);
}
