import { useMutation } from "@tanstack/react-query";
import { queryClient } from "../main";
import type { Servico } from "../interfaces/Servico";

const atualizarServico = async (servico: Servico) : Promise<Servico> => {
  const response = await fetch("http://localhost:8080/servicos", {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(servico),
  });

  if (!response.ok) {
    throw new Error(
      "Ocorreu um erro ao atualizar o serviço. Status code: " + response.status
    );
  }

  return await response.json();
};

const useAtualizarServico = () => {
  return useMutation({
    mutationFn: (servico: Servico) => atualizarServico(servico),

    onSuccess: () => {
      queryClient.invalidateQueries({
        queryKey: ["servicos"],
      });
    },
  });
};

export default useAtualizarServico;