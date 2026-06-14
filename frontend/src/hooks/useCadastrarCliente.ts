import { useMutation } from "@tanstack/react-query";
import { queryClient } from "../main";
import isErrorResponse from "../util/isErrorResponse";
import type { Cliente } from "../interfaces/Cliente";

const cadastrarCliente = async (cliente: Cliente): Promise<Cliente> => {
  const response = await fetch("http://localhost:8080/clientes", {
    method: "POST",
    headers: {
        "Content-type": "Application/json"
    },
    body: JSON.stringify(cliente)
  });
  if (!response.ok) {
    const error: any = await response.json();
    if (isErrorResponse(error)) {
      throw error;
    } else {
      throw new Error(
        "Ocorreu um erro ao cadastrar o cliente. Status code: " +
          response.status
      );
    }
  }
  return await response.json();
};

const useCadastrarCliente = () => {
  return useMutation({
    mutationFn: (cliente: Cliente) => cadastrarCliente(cliente),
    onSuccess: () => {
      queryClient.invalidateQueries({
        queryKey: ["clientes"],
        exact: false
      })      
    }
  });
};
export default useCadastrarCliente;