import { useQuery } from "@tanstack/react-query";

const recuperarVeiculos = async () => {
  const num = await new Promise<number>((resolve) => {
    setTimeout(() => {
        return resolve(1)
    }, 1000)
  })  
  console.log(num);
  const response = await fetch("http://localhost:8080/veiculos");
  if (!response.ok) {
    throw new Error(
      "Ocorreu um erro ao recuperar veiculos. Status: " + response.status,
    );
  }
  return await response.json();
};

const useRecuperarVeiculos = () => {
  return useQuery({
    queryKey: ["veiculos", "todos"],
    queryFn: recuperarVeiculos,
    staleTime: 10_000,
  });
};
export default useRecuperarVeiculos;