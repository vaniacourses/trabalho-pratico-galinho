import { useMutation } from "@tanstack/react-query";
import type { Veiculo } from "../interfaces/Veiculo";
import { queryClient } from "../main";

const buscarVeiculoPorPlaca = async (placa: string): Promise<Veiculo> => {
  const response = await fetch(
    `http://localhost:8080/veiculos/placa/${placa}`
  );

  if (!response.ok) {
    throw new Error("Veículo não encontrado");
  }

  return await response.json();
};

const useBuscarVeiculoPorPlaca = () => {
  return useMutation({
    mutationFn: (placa: string) =>
      buscarVeiculoPorPlaca(placa),

    onSuccess: () => {
      queryClient.invalidateQueries({
        queryKey: ["veiculos"],
        exact: false
      });
    }
  });
};

export default useBuscarVeiculoPorPlaca;