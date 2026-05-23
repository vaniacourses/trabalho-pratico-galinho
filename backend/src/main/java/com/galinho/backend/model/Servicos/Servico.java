package com.galinho.backend.model.Servicos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.galinho.backend.model.Financeiro.PagamentoServico;
import com.galinho.backend.model.Usuarios.Mecanico;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private Date dataInicio;
    private Date dataFim;
    private Date dataPrevisao;
    private String descricao;
    private BigDecimal Orcamento;
    
    //@OneToOne
    //private PagamentoServico pagamento;
    @OneToMany
    private List<Mecanico> mecanicos;
    @ManyToOne
    @JoinColumn(name = "veiculo_placa")
    private Veiculo veiculo;

    public Servico(String descricao, BigDecimal Orcamento, Date dataPrevisao, Veiculo veiculo){
        this.descricao = descricao;
        this.Orcamento = Orcamento;
        this.veiculo = veiculo;
        dataInicio = new Date();
        this.dataPrevisao = dataPrevisao;
        this.status = "A ser iniciado";
        mecanicos = new ArrayList<>();
    }
}
