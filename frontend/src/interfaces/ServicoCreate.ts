import type { Veiculo } from "./Veiculo";
import type { Mecanico } from "./Mecanico";
import type { PagamentoServico } from "./PagamentoServico";
import type { ProdutoServico } from "./ProdutoServico";
import type { Tarefa } from "./Tarefa";

export interface ServicoCreate {
    // id?: number;
    status: string;
    dataInicio: string | null;
    // dataFim: Date;
    dataPrevisao: string | null;
    descricao: string;
    orcamento: number;
    // pagamento: PagamentoServico;
    // mecanicos: Mecanico[];
    veiculoPlaca: string;//veiculoId: number;
    // produtosUsados: ProdutoServico[];
    // conjuntoTarefas: Tarefa;
}

