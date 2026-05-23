package com.galinho.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.galinho.backend.dto.ProdutoDto;
import com.galinho.backend.model.Estoque.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    @Query("select p from Produto p left join fetch p.fornecedor order by p.id")
    ProdutoDto recuperarProdutos();
}
