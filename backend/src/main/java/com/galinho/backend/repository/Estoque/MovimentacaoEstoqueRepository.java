package com.galinho.backend.repository.Estoque;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.galinho.backend.model.Estoque.MovimentacaoEstoque;

public interface MovimentacaoEstoqueRepository extends JpaRepository<MovimentacaoEstoque, Long>{
    @Query("""
        select m from MovimentacaoEstoque m 
        left join fetch m.lote
        order by m.id
    """) 
    List<MovimentacaoEstoque> recuperarMovimentacoes();    

    @Query("""
            select m 
            from MovimentacaoEstoque m 
            join m.lote l
            join l.produto p
            where p.id = :idProduto 
            order by m.id 
            """)
    List<MovimentacaoEstoque> recuperarMovimentacoesPorProduto(@Param("idProduto") long idProduto);
}