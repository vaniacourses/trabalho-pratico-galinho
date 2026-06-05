import type { Veiculo } from "./Veiculo";
import type { Mecanico } from "./Mecanico";
import type { PagamentoServico } from "./PagamentoServico";
import type { ProdutoServico } from "./ProdutoServico";
import type { Tarefa } from "./Tarefa";

export interface Servico {
    id: number;
    status: string;
    dataInicio: Date;
    dataFim: Date;
    dataPrevisao: Date;
    descricao: string;
    orcamento: number;
    pagamento: PagamentoServico;
    mecanicos: Mecanico[];
    veiculo: Veiculo;
    produtosUsados: ProdutoServico[];
    conjuntoTarefas: Tarefa;
}