package com.galinho.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.galinho.backend.utils.TipoStatus;

public record HistoricoServicoDto(
    Long id,
    LocalDateTime date,
    TipoStatus statusDoMomento,
    BigDecimal orcamentoDoMomento,
    @JsonProperty("servico")
    ServicoDto servicoDto
) {
    
}