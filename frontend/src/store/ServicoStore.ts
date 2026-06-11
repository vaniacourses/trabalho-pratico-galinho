import { create } from "zustand";
import type { Servico } from "../interfaces/Servico";

interface ServicoStore {
    status: string;   
    idRemovendo: number | null;
    //mensagem: string;
    servicoSelecionado: Servico;

    setIdRemovendo: (novoIdRemovendo: number | null) => void;
    //setMensagem: (novaMensagem: string) => void;
    setServicoSelecionado: (novoServicoSelecionado: Servico) => void;
}

const useServicoStore = create<ServicoStore>((set) => ({
    status: "",
    idRemovendo: null,
    //mensagem: "",
    servicoSelecionado: {} as Servico,
    
    setStatus: (novoStatus: string) => set(() => ({status: novoStatus})),
    setIdRemovendo:  (novoIdRemovendo: number | null) => set(() => ({idRemovendo: novoIdRemovendo})),
    //setMensagem:  (novaMensagem: string) => set(() => ({mensagem: novaMensagem})),
    setServicoSelecionado: (novoServicoSelecionado: Servico) => 
        set(() => ({servicoSelecionado: novoServicoSelecionado}))
}))
export default useServicoStore