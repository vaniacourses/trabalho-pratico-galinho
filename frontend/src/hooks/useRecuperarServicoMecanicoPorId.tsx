import { useQuery } from "@tanstack/react-query";

const recuperarServicoMecanicoPorId = async (id: number) => {
  const response = await fetch("http://localhost:8080/servicos/mecanico/" + id);
  if (!response.ok) {
    throw new Error(
      "Ocorreu um erro ao recuperar servico (" + id + "). Status: " + response.status,
    );
  }
  return await response.json();
};

const useRecuperarServicoMecanicoPorId = (id: number) => {
  return useQuery({
    queryKey: ["servicos", "mecanico" , id],
    queryFn: () => recuperarServicoMecanicoPorId(id),
    //enabled: !removido
    // staleTime: 10_000,
  });
};
export default useRecuperarServicoMecanicoPorId;