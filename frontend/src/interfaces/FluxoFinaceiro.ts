export interface FluxoFinanceiro {
  id: number;
  valor: number;
  titulo: string;
  descricao: string;
  tipo: "ENTRADA" | "SAIDA";
  data: string;
  origemOuDestino: string;
}

export interface FluxoFinanceiroCreate {
  valor: number;
  titulo: string;
  descricao: string;
  tipo: "ENTRADA" | "SAIDA";
  data: string;
  origemOuDestino: string;
}