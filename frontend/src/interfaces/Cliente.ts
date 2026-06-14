import type { List } from "lodash";
import type { Veiculo } from "./Veiculo";

export interface Cliente{
    id?: number;
    nome: string;
    email: string;
    senha: string;
    cpf: string;
    telefone: string;
    dataCadastro?: Date;
    endereco: string;
    veiculos?: List<Veiculo>;
    role?: string;
}