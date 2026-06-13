package com.galinho.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.galinho.backend.model.Estoque.ProdutoServico;
import com.galinho.backend.model.Financeiro.PagamentoServico;
import com.galinho.backend.model.Servicos.Veiculo;
import com.galinho.backend.model.Servicos.Tarefa.Tarefa;
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
    //String veiculoPlaca
    //Tarefa conjuntoTarefas, //Faz sentido usuario ver conj de tarefas
    //List<ProdutoServico> produtosUsados
    //Sem mecanicos
) {
    
}
