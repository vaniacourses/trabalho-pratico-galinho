package com.galinho.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.galinho.backend.model.Servicos.HistoricoServico;

public interface HistoricoServicoRepository extends JpaRepository<HistoricoServico, Long>{
    @Query("""
        select h from HistoricoServico h 
        left join fetch h.servico 
         
        order by h.id
    """)
    List<HistoricoServico> recuperarHistoricoServicos();   
}
