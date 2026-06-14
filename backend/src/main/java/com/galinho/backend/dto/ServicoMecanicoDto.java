package com.galinho.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import com.galinho.backend.model.Estoque.ProdutoServico;
import com.galinho.backend.model.Financeiro.PagamentoServico;
import com.galinho.backend.model.Servicos.Veiculo;
import com.galinho.backend.model.Servicos.Tarefa.TarefaEntity;
import com.galinho.backend.model.Usuarios.Mecanico;
import com.galinho.backend.utils.TipoStatus;

public record ServicoMecanicoDto(
    Long id,
    TipoStatus status,
    LocalDateTime dataInicio,
    LocalDateTime dataFim,
    LocalDateTime dataPrevisao,
    String descricao,
    BigDecimal orcamento,
    PagamentoServico pagamento,
    Veiculo veiculo,
    TarefaEntity conjuntoTarefas,
    Set<ProdutoServico> produtosUsados,
    Set<Mecanico> mecanicos
){}
