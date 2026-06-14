package com.galinho.backend.repository.Estoque;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.galinho.backend.model.Estoque.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    @Query("select p from Produto p order by p.id")
    List<Produto> recuperarProdutos();
}
