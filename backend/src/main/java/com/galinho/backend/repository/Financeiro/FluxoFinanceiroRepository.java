package com.galinho.backend.repository.Financeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.galinho.backend.model.Financeiro.FluxoFinanceiro;

@Repository                                                      // Entidade    , ID
public interface FluxoFinanceiroRepository extends JpaRepository<FluxoFinanceiro, Long> {
}