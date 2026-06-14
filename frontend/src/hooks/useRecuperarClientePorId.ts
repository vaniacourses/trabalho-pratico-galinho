import { useQuery } from "@tanstack/react-query";

const recuperarClientePorId = async (id: number) => {
  const response = await fetch("http://localhost:8080/clientes/" + id);
  if (!response.ok) {
    throw new Error(
      "Ocorreu um erro ao recuperar cliente. Status: " + response.status,
    );
  }
  return await response.json();
};

const useRecuperarClientePorId = (id: number) => {
  return useQuery({
    queryKey: ["clientes", id],
    queryFn: () => recuperarClientePorId(id)
  });
};
export default useRecuperarClientePorId;
