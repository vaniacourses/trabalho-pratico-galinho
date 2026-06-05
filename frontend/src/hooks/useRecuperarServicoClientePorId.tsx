import { useQuery } from "@tanstack/react-query";

const recuperarServicoClientePorId = async (id: number) => {
  const response = await fetch("http://localhost:8080/servicos/" + id);
  if (!response.ok) {
    throw new Error(
      "Ocorreu um erro ao recuperar servico (" + id + "). Status: " + response.status,
    );
  }
  return await response.json();
};

const useRecuperarServicoClientePorId = (id: number) => {
  return useQuery({
    queryKey: ["servicos", "cliente" , id],
    queryFn: () => recuperarServicoClientePorId(id),
    //enabled: !removido
    // staleTime: 10_000,
  });
};
export default useRecuperarServicoClientePorId;