package com.galinho.backend.model.Servicos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.galinho.backend.model.Estoque.ProdutoServico;
import com.galinho.backend.model.Financeiro.PagamentoServico;
import com.galinho.backend.model.Servicos.Tarefa.Tarefa;
import com.galinho.backend.model.Servicos.Tarefa.TarefaEntity;
import com.galinho.backend.model.Usuarios.Mecanico;
import com.galinho.backend.utils.TipoStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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
    @Enumerated(EnumType.STRING)
    private TipoStatus status;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private LocalDateTime dataPrevisao;
    private String descricao;
    private BigDecimal orcamento;
    
    @OneToOne
    private PagamentoServico pagamento;
    @OneToMany
    private Set<Mecanico> mecanicos;
    @ManyToOne
    @JoinColumn(name = "veiculo_placa")
    private Veiculo veiculo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conjunto_tarefas_id")
    private TarefaEntity conjuntoTarefas;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<ProdutoServico> produtosUsados;


    public Servico(String descricao, BigDecimal orcamento, LocalDateTime dataPrevisao, Veiculo veiculo){
        this.descricao = descricao;
        this.orcamento = orcamento;
        this.veiculo = veiculo;
        dataInicio = LocalDateTime.now();
        this.dataPrevisao = dataPrevisao;
        this.status = TipoStatus.A_SER_INICIADO;
        mecanicos = new HashSet<>();
    }
}
