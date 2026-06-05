export interface Tarefa {
    id: number;
    descricao: string;
    valor: number;
    data: Date;
    tarefa?: Tarefa;
}