package com.galinho.backend.dto;

import java.util.Date;
import java.util.List;

import com.galinho.backend.model.Financeiro.PagamentoServico;
import com.galinho.backend.model.Servicos.Veiculo;


public record ServicoDto(
    Long id,
    String status,
    Date dataInicio,
    Date dataFim,
    Date dataPrevisao,
    String descricao,
    int orcamento,
    PagamentoServico pagamento,
    Veiculo veiculo
    //Sem mecanicos
) {
    
}
