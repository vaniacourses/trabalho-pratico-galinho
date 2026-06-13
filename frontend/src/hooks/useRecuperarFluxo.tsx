import { useQuery } from "@tanstack/react-query";
import type { FluxoFinanceiro } from "../interfaces/FluxoFinaceiro";

const recuperarFluxos = async (): Promise<FluxoFinanceiro[]> => {
  const response = await fetch("http://localhost:8080/financeiro/fluxos");
  if (!response.ok) throw new Error("Erro ao buscar os fluxos financeiros");
  return response.json();
};

const useRecuperarFluxos = (filtroAtivo: { inicio: string; fim: string; }) => {
  return useQuery({
    queryKey: ["fluxos"],
    queryFn: recuperarFluxos,
  });
};

export default useRecuperarFluxos;