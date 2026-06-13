import { useMutation, useQueryClient } from "@tanstack/react-query";
import type { FluxoFinanceiroCreate } from "../interfaces/FluxoFinaceiro";

const adicionarFluxo = async (fluxo: FluxoFinanceiroCreate) => {
  const response = await fetch("http://localhost:8080/financeiro/fluxos", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(fluxo),
  });
  if (!response.ok) throw new Error("Erro ao adicionar fluxo");
  return response.json();
};

const useAdicionarFluxo = () => {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: adicionarFluxo,
    onSuccess: () => {
      // Invalida o cache para forçar a tabela a buscar os dados novos
      queryClient.invalidateQueries({ queryKey: ["fluxos"] });
    },
  });
};

export default useAdicionarFluxo;