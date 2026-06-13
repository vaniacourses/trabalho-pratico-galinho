import type { Servico } from "./Servico";

export interface HistoricoServico {
    id: number;
    date: string;
    statusDoMomento: string;
    orcamentoDoMomento: number;
    servico: Servico;
    descricao: string;
}