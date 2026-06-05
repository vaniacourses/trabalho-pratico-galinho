package com.galinho.backend.repository.Financeiro;
import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.galinho.backend.model.Financeiro.FluxoFinanceiro;

@Repository
public interface FluxoFinanceiroRepository extends JpaRepository<FluxoFinanceiro, Long> {

    // Calcula todas as entradas
    @Query("SELECT COALESCE(SUM(f.valor), 0) FROM FluxoFinanceiro f WHERE f.tipo = 'ENTRADA'")
    BigDecimal somarEntradas();

    // Calcula todas as saídas
    @Query("SELECT COALESCE(SUM(f.valor), 0) FROM FluxoFinanceiro f WHERE f.tipo = 'SAIDA'")
    BigDecimal somarSaidas();
}