package com.galinho.backend.factory.Financeiro;

import java.math.BigDecimal;

import com.galinho.backend.model.Financeiro.PagamentoServico;
/**

 * @param <T> O tipo da Entidade que será criada (Pix, Dinheiro, Cartao)
 * @param <D> O tipo do DTO que contém os dados da requisição
 */
public interface PagamentoFactory<T extends PagamentoServico, D> {
    
    T criarPagamento(BigDecimal valorOrcamento, D dto);

}