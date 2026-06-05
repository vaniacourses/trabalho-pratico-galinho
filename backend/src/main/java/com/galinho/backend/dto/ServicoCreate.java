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

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Null;


public record ServicoCreate(
    @Null Long id,
    TipoStatus status,
    LocalDateTime dataInicio,
    LocalDateTime dataFim,
    LocalDateTime dataPrevisao,
    String descricao,
    BigDecimal orcamento,
    PagamentoServico pagamento,
    String veiculoPlaca
    //Long veiculoId
    //Tarefa conjuntoTarefas
    //ProdutoServico produtosUsados
    //Sem mecanicos
) {
    
}
