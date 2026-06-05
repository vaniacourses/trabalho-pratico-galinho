import type { Tarefa } from "../interfaces/Tarefa";

export function recuperarTarefas(conjunto: any): Tarefa[] {
    const lista: Tarefa[] = [];

    let atual = conjunto;

    while (atual) {
        lista.push(atual);
        atual = atual.tarefaDecorada;
    }

    return lista.reverse();
}