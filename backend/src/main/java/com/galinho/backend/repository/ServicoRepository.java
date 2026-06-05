package com.galinho.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.galinho.backend.model.Servicos.Servico;
import com.galinho.backend.utils.TipoStatus;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
    @Query("""
        select s from Servico s 
        left join fetch s.veiculo 
        left join fetch s.mecanicos 
         
        order by s.id
    """) //left join fetch s.pagamento
    List<Servico> recuperarServicos();   
    

    @Query("""
        select s from Servico s 
        left join fetch s.veiculo 
        left join fetch s.mecanicos 
        where s.status <> com.galinho.backend.utils.TipoStatus.CONCLUIDO 
        order by s.id
    """)
    List<Servico> recuperarServicosEmProcesso();

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

    //List<Servico> findByStatusOrderByDataInicioAsc(TipoStatus status); //Passar TipoStatus.BLABLA
    
    // @Query("""
    //         select distinct s
    //         from Servico s
    //         join fetch s.veiculo v
    //         join fetch v.cliente
    //         join fetch s.mecanicos
    //         join fetch s.conjuntoTarefas
    //         left join fetch s.produtosUsados
    //         where s.id = :idServico
    //         """)
    // Servico recuperarServicosPorId(@Param("idServico") long idServico);

    @Query("""
        select s from Servico s 
        left join fetch s.veiculo 
        left join fetch s.mecanicos 
        left join fetch s.conjuntoTarefas
        where s.id = :idServico
    """) //left join fetch s.pagamento
    Servico recuperarServicosPorId(@Param("idServico") long idServico);  
  

}