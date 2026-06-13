import type { PagamentoServico } from "./PagamentoServico";
import type { Veiculo } from "./Veiculo";

export interface ServicoUpdate {
    id: number;
    status: string;
    dataInicio: Date;
    dataFim: Date;
    dataPrevisao: Date;
    descricao: string;
    orcamento: number;
    pagamento: PagamentoServico;
    veiculo: Veiculo;
    //veiculoPlaca: string;
}


// Long id,
// TipoStatus status,
// LocalDateTime dataInicio,
// LocalDateTime dataFim,
// LocalDateTime dataPrevisao,
// String descricao,
// BigDecimal orcamento,
// PagamentoServico pagamento,
// Veiculo veiculo