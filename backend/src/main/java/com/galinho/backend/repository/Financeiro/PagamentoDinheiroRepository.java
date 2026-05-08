package com.galinho.backend.repository.Financeiro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.galinho.backend.model.Financeiro.PagamentoDinheiro;

@Repository
public interface PagamentoDinheiroRepository extends JpaRepository<PagamentoDinheiro, Long> {
}
