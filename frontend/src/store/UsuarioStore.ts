import { create } from "zustand";

interface UsuarioStore {
    usuarioLogado: number;
    roleUsuarioLogado: string;
    setRoleUsuarioLogado: (novaRoleUsuarioLogado: string) => void;
}

const useUsuarioStore = create<UsuarioStore>((set) => ({
    usuarioLogado: 0,
    roleUsuarioLogado: "",
    setUsuarioLogado: (novoUsuarioLogado: number) => set(() => ({usuarioLogado: novoUsuarioLogado})),
    setRoleUsuarioLogado: (novaRoleUsuarioLogado: string) => set(() => ({roleUsuarioLogado: novaRoleUsuarioLogado}))
}))
export default useUsuarioStore