package com.galinho.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.galinho.backend.model.Servicos.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
    @Query("""
        select s from Servico s 
        left join fetch s.veiculo 
        left join fetch s.mecanicos 
        left join fetch s.pagamento 
        order by s.id
    """)
    public List<Servico> recuperarServicos();    
}