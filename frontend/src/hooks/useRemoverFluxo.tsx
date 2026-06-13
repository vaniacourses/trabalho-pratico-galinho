import { useMutation, useMutationState, useQueryClient } from "@tanstack/react-query";

const removerFluxo =  async (id:number) => {
    const response = await fetch(`http://localhost:8080/financeiro/fluxos/${id}`, {
    method: "DELETE",
  });
  if (!response.ok) throw new Error("Erro ao deletar fluxo");
}

const   useRemoverFluxo = () => {
    const queryClient = useQueryClient();
    return useMutation({
        mutationFn: removerFluxo,
        onSuccess: () => {
            queryClient.invalidateQueries({ queryKey: ["fluxos"]});
        },
    });
};

export default useRemoverFluxo