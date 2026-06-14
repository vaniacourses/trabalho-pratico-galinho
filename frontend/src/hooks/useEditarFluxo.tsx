import { useMutation, useQueryClient } from "@tanstack/react-query";

interface EdicaoPayload {
  id: number;
  dados: any;
}

const editarFluxo = async ({ id, dados }: EdicaoPayload) => {
  const response = await fetch(`http://localhost:8080/financeiro/fluxos/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(dados),
  });

  if (!response.ok) {
    const errorData = await response.json().catch(() => null);
    throw new Error(errorData?.message || "Erro ao atualizar a movimentação.");
  }

  return response.json();
};

const useEditarFluxo = () => {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: editarFluxo,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ["fluxos"] });
    },
  });
};

export default useEditarFluxo;