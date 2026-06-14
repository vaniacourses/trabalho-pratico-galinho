import { create } from "zustand";
import type { Cliente } from "../interfaces/Cliente";

interface ClienteStore {
    idRemovendo: number | null;
    clienteSelecionado: Cliente;

    setIdRemovendo: (novoIdRemovendo: number | null) => void;
    setClienteSelecionado: (novoCliente: Cliente) => void;
}

const useClienteStore = create<ClienteStore>((set) => ({
    idRemovendo: null,
    clienteSelecionado:{} as Cliente,
    
    setIdRemovendo:  (novoIdRemovendo: number | null) => set(() => ({idRemovendo: novoIdRemovendo})),
    setClienteSelecionado: (novoClienteSelecionado: Cliente) => 
        set(() => ({clienteSelecionado: novoClienteSelecionado}))
}))
export default useClienteStore