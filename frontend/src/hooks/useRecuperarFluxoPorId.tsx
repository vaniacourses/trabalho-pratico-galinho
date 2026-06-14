import { useQuery } from "@tanstack/react-query";
import type { FluxoFinanceiro } from "../interfaces/FluxoFinaceiro";


const recuperarFluxoPorId = async (id: number): Promise<FluxoFinanceiro> => {
  const response = await fetch(`http://localhost:8080/financeiro/fluxos/${id}`);
  if (!response.ok) throw new Error("Erro ao buscar detalhes do fluxo.");
  return response.json();
};

const useRecuperarFluxoPorId = (id: number) => {
  return useQuery({
    queryKey: ["fluxo", id],
    queryFn: () => recuperarFluxoPorId(id),
    enabled: !!id,
  });
};

export default useRecuperarFluxoPorId;