package com.galinho.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.galinho.backend.model.Servicos.Servico;
import com.galinho.backend.utils.TipoStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;

public record HistoricoServicoDto(
    Long id,
    LocalDateTime date,
    TipoStatus statusDoMomento,
    BigDecimal orcamentoDoMomento,
    @JsonProperty("servico")
    ServicoDto servicoDto,
    String descricao
) {
    
}