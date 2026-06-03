import { useQuery } from "@tanstack/react-query";

const recuperarServicos = async () => {
  const num = await new Promise<number>((resolve) => {
    setTimeout(() => {
        return resolve(1)
    }, 1000)
  })  
  console.log(num);
  const response = await fetch("http://localhost:8080/servicos");
  if (!response.ok) {
    throw new Error(
      "Ocorreu um erro ao recuperar servicos. Status: " + response.status,
    );
  }
  return await response.json();
};

const useRecuperarServicos = () => {
  return useQuery({
    queryKey: ["servicos"],
    queryFn: recuperarServicos,
    staleTime: 10_000,
  });
};
export default useRecuperarServicos;