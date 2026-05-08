package com.galinho.backend.model.Financeiro;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class HistoricoFinanceiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal saldoAtual;
    private BigDecimal quantiaDeEntrada;
    private BigDecimal quantiaDeSaida;  
    
    @OneToMany(mappedBy = "historico", cascade = CascadeType.ALL)
    private List <FluxoFinanceiro> fluxos = new ArrayList<>();
    
    public HistoricoFinanceiro(BigDecimal saldoAtual, BigDecimal quantiaDeEntrada, BigDecimal quantiaDeSaida) {
        this.saldoAtual = saldoAtual;
        this.quantiaDeEntrada = quantiaDeEntrada;
        this.quantiaDeSaida = quantiaDeSaida;
    }
}
