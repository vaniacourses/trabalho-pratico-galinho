package com.galinho.backend.mapper.Financeiro;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.galinho.backend.dto.Financeiro.FluxoFinanceiroDTO;
import com.galinho.backend.dto.Financeiro.HistoricoFinanceiroDTO;
import com.galinho.backend.dto.Financeiro.PagamentoDTO;
import com.galinho.backend.model.Financeiro.FluxoFinanceiro;
import com.galinho.backend.model.Financeiro.HistoricoFinanceiro;
import com.galinho.backend.model.Financeiro.PagamentoCartao;
import com.galinho.backend.model.Financeiro.PagamentoDinheiro;
import com.galinho.backend.model.Financeiro.PagamentoPix;
import com.galinho.backend.model.Financeiro.PagamentoServico;

@Mapper(componentModel = "spring")
public interface FinanceiroMapper {

    // Model -> Dto
    HistoricoFinanceiroDTO toHistoricoFinanceiroDTO(HistoricoFinanceiro historico);
    FluxoFinanceiroDTO toFluxoFinanceiroDTO(FluxoFinanceiro fluxo);

    @Mapping(source = "servico.id", target = "idServico")
    @Mapping(source = "id", target = "idPagamento")
    @Mapping(target =  "tipoPagamento", expression = "java(tipoPagamento(pagamento))") // Diz como vai preencher o tipoPagamento que tem no DTO
    PagamentoDTO toPagamentoDTO(PagamentoServico pagamento);                           // mas n tem no model

    @Mapping(target = "historico", ignore = true) // o mapper n pode preencher o historico
    FluxoFinanceiro toFluxoFinanceiroEntity(FluxoFinanceiro dto);

    public default String tipoPagamento(PagamentoServico pagamento){
        if(pagamento instanceof PagamentoPix) return "PIX";
        if(pagamento instanceof PagamentoCartao) return "CARTAO";
        if(pagamento instanceof PagamentoDinheiro) return "DINHEIRO";
        return "???";
    }
} 
