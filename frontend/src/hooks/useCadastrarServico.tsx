import { useMutation } from "@tanstack/react-query";
import { queryClient } from "../main";
import type { ServicoCreate } from "../interfaces/ServicoCreate";
import type { Servico } from "../interfaces/Servico";

const cadastrarServico = async (servico: ServicoCreate): Promise<Servico> => {
  console.log(JSON.stringify(servico, null, 2));

  const response = await fetch("http://localhost:8080/servicos", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(servico)
  });

  if (!response.ok) {
    const erro = await response.text();
    console.error("Erro backend:", erro);
    throw new Error(
      "Erro ao cadastrar serviço. Status: " + response.status
    );
  }

  return await response.json();
};

const useCadastrarServico = () => {
  return useMutation({
    mutationFn: (servico: ServicoCreate) =>
      cadastrarServico(servico),

    onSuccess: () => {
      queryClient.invalidateQueries({
        queryKey: ["servicos"],
        exact: false
      });
    }
  });
};

export default useCadastrarServico;