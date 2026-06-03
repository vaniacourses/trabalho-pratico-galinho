import type { Fornecedor } from "./Fornecedor";
import type { Produto } from "./Produto";

export interface LoteProduto{
    id: number;
    codigoLote: number;
    validade: String;
    quantidade: number;
    produto: Produto;
    fornecedor: Fornecedor;
}