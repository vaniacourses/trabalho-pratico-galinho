import type { Fornecedor } from "./Fornecedor";
import type { Produto } from "./Produto";

export interface LoteProdutoCreate {
  id: null;
  quantidade: number;
  validade: string;
  codigoLote: string;
  fornecedorId: number;
  produtoId: number;
}
