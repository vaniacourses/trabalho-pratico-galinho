import type { List } from "lodash";
import type { Produto } from "./Produto";

export interface Fornecedor{
    id: number;
    nome: String;
    email: String;
    cnpj: String;
    endereco: String;
    produtos: List<Produto>
}