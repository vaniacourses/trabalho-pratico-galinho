import { useMutation, useQueryClient } from "@tanstack/react-query";

interface DadosPagamento {
    idServico: number;
    tipoMetodo: "PIX" | "DINHEIRO" | "CARTAO";
    payload: any;
}

const processarPagamento = async ({idServico, tipoMetodo, payload}: DadosPagamento) => {
    const endpoint = `http://localhost:8080/financeiro/pagamentos/${tipoMetodo.toLowerCase()}/${idServico}`;
    const response = await fetch(endpoint,{
        method: "POST",
        headers: {"Content-Type": "aplication/jason"},
        body: JSON.stringify(payload),
    });

    if(!response.ok){
        const errorData = await response.json().catch(() => null);
        throw new Error(errorData?.message || "Erro ao registrar o pagamento.");
    }

    return response.json();
}

const useRealizarPagamento = () => {
    const queryClient = useQueryClient();
    return useMutation({
    mutationFn: processarPagamento,
    onSuccess: () => {
      // Invalida o cache 
      queryClient.invalidateQueries({ queryKey: ["fluxos"] });
      queryClient.invalidateQueries({ queryKey: ["servicos"] });
    },
  });
};

export default useRealizarPagamento;
