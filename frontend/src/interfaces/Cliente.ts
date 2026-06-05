import type { List } from "lodash";
import type { Veiculo } from "./Veiculo";

export interface Cliente{
    id: number;
    nome: String;
    email: String;
    senha: String;
    cpf: String;
    telefone: String;
    dataCadastro: String;
    veiculos: List<Veiculo>;
}