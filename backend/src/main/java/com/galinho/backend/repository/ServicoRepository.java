package com.galinho.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.galinho.backend.model.Servicos.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
    @Query("""
        select s from Servico s 
        left join fetch s.veiculo 
        left join fetch s.mecanicos 
         
        order by s.id
    """) //left join fetch s.pagamento
    List<Servico> recuperarServicos();    

    @Query("""
            select s 
            from Servico s 
            join s.veiculo v 
            join v.cliente c 
            where c.id = :idCliente 
            order by s.id 
            """)
    List<Servico> recuperarServicosDeCliente(@Param("idCliente") long idCliente);

    @Query("""
            select s
            from Servico s
            join s.veiculo v
            join v.cliente c
            where c.id = :idCliente and s.id = :idServico
            """)
    Servico recuperarServicoDeCliente(@Param("idServico") long idServico, @Param("idCliente") long idCliente);

}