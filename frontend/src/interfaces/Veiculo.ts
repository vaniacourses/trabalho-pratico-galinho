import type { List } from "lodash";
import type { Cliente } from "./Cliente";
import type { Servico } from "./Servico";

export interface Veiculo{
    id: number;
    placa: String;
    servicos: List<Servico>;
    cliente: Cliente;
}