package com.galinho.backend.model.Servicos.Tarefa;

import java.math.BigDecimal;

// nao pode anotar interface com @Entity -> Criamos TarefaEntity para representar Tarefa persistentemente
public interface Tarefa {
    public BigDecimal calcularValor();
    public String getDescricao();
    public String getDescricaoTotal();
}
