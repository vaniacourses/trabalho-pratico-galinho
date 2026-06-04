import { useQuery } from "@tanstack/react-query";

const recuperarServicoPorId = async (id: number) => {
  const response = await fetch("http://localhost:8080/servicos/" + id);
  if (!response.ok) {
    throw new Error(
      "Ocorreu um erro ao recuperar servico (" + id + "). Status: " + response.status,
    );
  }
  return await response.json();
};

const useRecuperarServicoPorId = (id: number) => {
  return useQuery({
    queryKey: ["servicos", id],
    queryFn: () => recuperarServicoPorId(id),
    //enabled: !removido
    // staleTime: 10_000,
  });
};
export default useRecuperarServicoPorId;