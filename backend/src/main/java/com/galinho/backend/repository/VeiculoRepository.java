package com.galinho.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.galinho.backend.model.Servicos.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
    // recuperar todos os veiculos
    @Query("""
        select v from Veiculo v 
        left join fetch v.servicos 
        left join fetch v.cliente 
        order by v.id
    """)
    List<Veiculo> recuperarVeiculos();

    // recuperar veiculos por cliente
    @Query("""
        select v from Veiculo v 
        left join fetch v.servicos 
        left join fetch v.cliente c 
        where c.id = :idCliente 
        order by v.id
    """)
    List<Veiculo> recuperarVeiculosPorCliente(@Param("idCliente") Long idCliente);

    // recuperar por placa
    @Query("""
        select v from Veiculo v 
        left join fetch v.servicos 
        left join fetch v.cliente 
        where v.placa = :placa 
        order by v.id
    """)
    Optional<Veiculo> recuperarVeiculoPorPlaca(@Param("placa") String placa);


    // recuperar veiculo de cliente
    @Query("""
        select v from Veiculo v 
        left join fetch v.servicos 
        left join fetch v.cliente c 
        where v.id = :idVeiculo and c.id = :idCliente 
        order by v.id
    """)        
    Veiculo recuperarVeiculoDeCliente(@Param("idVeiculo") Long idVeiculo, @Param("idCliente") Long idCliente);
}

