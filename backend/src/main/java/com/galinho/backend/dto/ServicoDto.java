package com.galinho.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.galinho.backend.model.Financeiro.PagamentoServico;
import com.galinho.backend.model.Servicos.Veiculo;
import com.galinho.backend.utils.TipoStatus;


public record ServicoDto(
    Long id,
    TipoStatus status,
    LocalDateTime dataInicio,
    LocalDateTime dataFim,
    LocalDateTime dataPrevisao,
    String descricao,
    BigDecimal orcamento,
    PagamentoServico pagamento,
    Veiculo veiculo
    //Tarefa conjuntoTarefas, //Faz sentido usuario ver conj de tarefas
    //List<ProdutoServico> produtosUsados
    //Sem mecanicos
) {
    
}
