package com.galinho.backend.dto;

import java.util.Date;
import java.util.List;

import com.galinho.backend.model.Financeiro.PagamentoServico;
import com.galinho.backend.model.Servicos.Veiculo;

import jakarta.validation.constraints.Null;


public record ServicoCreate(
    @Null Long id,
    String status,
    Date dataInicio,
    Date dataFim,
    Date dataPrevisao,
    String descricao,
    int Orcamento,
    PagamentoServico pagamento,
    Veiculo veiculo
    //Sem mecanicos
) {
    
}
