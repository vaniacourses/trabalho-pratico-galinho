import type { Produto } from "./Produto";

export interface ProdutoServico{
    id: number;
    precoDoMomento: number;
    quantidade: number;
    produto: Produto;
}