package com.galinho.backend.repository.Financeiro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.galinho.backend.model.Financeiro.PagamentoCartao;

@Repository
public interface PagamentoCartaoRepository extends JpaRepository<PagamentoCartao, Long> {
}