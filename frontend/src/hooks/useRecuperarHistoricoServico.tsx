import { useQuery } from "@tanstack/react-query";

const recuperarHistoricoServico = async (id: number) => {
  const response = await fetch("http://localhost:8080/historico/servico/" + id);
  if (!response.ok) {
    throw new Error(
      "Ocorreu um erro ao recuperar servico (" + id + "). Status: " + response.status,
    );
  }
  return await response.json();
};

const useRecuperarHistoricoServico = (id: number) => {
  return useQuery({
    queryKey: ["servicos", "historico" , id],
    queryFn: () => recuperarHistoricoServico(id),
    //enabled: !removido
    // staleTime: 10_000,
  });
};
export default useRecuperarHistoricoServico;