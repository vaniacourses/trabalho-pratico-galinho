import { useMutation } from "@tanstack/react-query";
import type { Servico } from "../interfaces/Servico";
import { queryClient } from "../main";

const removerServicoPorId = async (id: number) => {
  await new Promise<void>((resolve) => {
    setTimeout(() => {
      resolve();
    }, 2000)
  })

  const response = await fetch("http://localhost:8080/servicos/" + id, {
    method: "DELETE",
  });
  if (!response.ok) {
    throw new Error(
      "Ocorreu um erro ao remover Servico. Status code: " + response.status,
    );
  }
  // return await response.json() - Não retorna nada uma vez que o back-end retorna void
};

const useRemoverServicoOtimista = () => {
  return useMutation({
    mutationFn: (id: number) => removerServicoPorId(id),

    // A função definida em onMutate é executada antes da mutation function ser executada.
    // Ela atualiza o cache, removendo dele o Servico que será removido pela mutation function
    onMutate: (id: number) => {
      // Salva em ServicosAntesDaRemocao os Servicos que serão uilizados para restabelecer 
      // o cache "Servicos" caso a remoção falhe.
      const ServicosAntesDaRemocao = queryClient.getQueryData<Servico[]>(["servicos"]);
      console.log("ServicosAntesDaRemocao = ", ServicosAntesDaRemocao);

      // Atualiza o cache removendo dele o Servico que será removido.
      // O cache será atualizado pela lista de Servicos retornada função filter que retorna 
      // uma nova lista contendo todos os Servicos que possuem um id com valor diferente do 
      // parâmetro id. Veja o parâmetro acima.
      queryClient.setQueryData<Servico[]>(["servicos"], (Servicos) => {
        return Servicos?.filter((Servico) => Servico.id !== id);
      })

      // Os Servicos retornados em ServicosAntesDaRemocao estarão disponíveis em context da 
      // função onError abaixo. Sem o return abaixo, context não terá ServicosAntesDaRemocao.
      return {ServicosAntesDaRemocao};
    },
    onError: (error, id, context) => {
      console.log("id = ", id);
      // Ao ocorrer um erro na remoção de um Servico, é preciso restaurar o cache ("Servicos") 
      // para o seu estado antes da remoção do Servico. 
      queryClient.setQueryData(["servicos"], context?.ServicosAntesDaRemocao);
    },
  });
};
export default useRemoverServicoOtimista;