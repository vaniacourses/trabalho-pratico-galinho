package com.galinho.backend.repository.Estoque;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.galinho.backend.model.Estoque.LoteProduto;

public interface LoteProdutoRepository extends JpaRepository<LoteProduto, Long>{
    @Query("""
        select l from LoteProduto l 
        left join fetch l.produto
        left join fetch l.fornecedor
        order by l.id
    """) 
    List<LoteProduto> recuperarLotes();    

    @Query("""
            select l 
            from LoteProduto l 
            join l.produto p 
            where p.id = :idProduto 
            order by l.id 
            """)
    List<LoteProduto> recuperarLotesPorProduto(@Param("idProduto") long idProduto);
}
