import { useMutation } from "@tanstack/react-query";
import { queryClient } from "../main";
import isErrorResponse from "../util/isErrorResponse";
import type { Cliente } from "../interfaces/Cliente";

const alterarCliente = async (cliente: Cliente): Promise<Cliente> => {
  const response = await fetch("http://localhost:8080/clientes", {
    method: "PUT",
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
        "Ocorreu um erro ao alterar o cliente. Status code: " +
          response.status
      );
    }
  }
  return await response.json();
};

const useAlterarCliente = () => {
  return useMutation({
    mutationFn: (cliente: Cliente) => alterarCliente(cliente),
    onSuccess: () => {
      queryClient.invalidateQueries({
        queryKey: ["clientes"],
        exact: false
      })      
    }
  });
};
export default useAlterarCliente;