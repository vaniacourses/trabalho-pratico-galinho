import { useQuery } from "@tanstack/react-query";

const recuperarLoteProdutos = async () => {
  const response = await fetch("http://localhost:8080/loteproduto");
  if (!response.ok) {
    throw new Error(
      "Ocorreu um erro ao recuperar produtos. Status: " + response.status,
    );
  }
  return await response.json();
};

const useRecuperarProdutos = () => {
  return useQuery({
    queryKey: ["loteProdutos"],
    queryFn: recuperarLoteProdutos,
    staleTime: 10_000,
  });
};
export default useRecuperarProdutos;
