import { useMutation } from "@tanstack/react-query";
import { queryClient } from "../main";
import type { LoteProdutoCreate } from "../interfaces/LoteProdutoCreate";
import type { LoteProduto } from "../interfaces/LoteProduto";

const cadastrarLoteProduto = async (
  loteProduto: LoteProdutoCreate,
): Promise<LoteProduto> => {
  console.log(JSON.stringify(loteProduto, null, 2));

  const response = await fetch("http://localhost:8080/loteproduto", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(loteProduto),
  });

  if (!response.ok) {
    const erro = await response.text();
    console.error("Erro backend:", erro);
    throw new Error("Erro ao cadastrar serviço. Status: " + response.status);
  }

  return await response.json();
};

const useCadastrarLoteProduto = () => {
  return useMutation({
    mutationFn: (loteProduto: LoteProdutoCreate) =>
      cadastrarLoteProduto(loteProduto),
    onSuccess: () => {
      queryClient.invalidateQueries({
        queryKey: ["loteProdutos"],
        exact: false,
      });
    },
  });
};

export default useCadastrarLoteProduto;
