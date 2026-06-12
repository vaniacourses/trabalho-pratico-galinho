import type { List } from "lodash";
import type { Cliente } from "./Cliente";
import type { Servico } from "./Servico";

export interface Veiculo{
    id: number;
    placa: string;
    cliente: Cliente;
    marca: string;
    modelo: string;
    ano: number;
    cor: string;
}