import type { LoteProduto } from "./LoteProduto";

export interface MovimentacaoEstoque{
    id: number;
    descricao: String;
    data: Date;
    quantidade: number;
    lote: LoteProduto;
}