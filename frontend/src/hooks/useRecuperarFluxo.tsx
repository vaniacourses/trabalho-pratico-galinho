import { useQuery } from "@tanstack/react-query";
import type { FluxoFinanceiro } from "../interfaces/FluxoFinaceiro";

interface FiltroAtivo {
  inicio: string;
  fim: string;
}

const recuperarFluxos = async (filtro: FiltroAtivo): Promise<FluxoFinanceiro[]> => {
  let url = "http://localhost:8080/financeiro/fluxos";
  
  if (filtro.inicio !== "" && filtro.fim !== "") {
    // Adiciona as horas para o Java aceitar como LocalDateTime
    const inicioFormatado = `${filtro.inicio}T00:00:00`;
    const fimFormatado = `${filtro.fim}T23:59:59`;
    
    url = `http://localhost:8080/financeiro/fluxos/periodo?inicio=${inicioFormatado}&fim=${fimFormatado}`;
  }

  const response = await fetch(url, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    }
  });
  
  if (!response.ok) {
    throw new Error("Erro ao buscar as movimentações financeiras.");
  }

  return response.json();
};

const useRecuperarFluxos = (filtro: FiltroAtivo) => {
  return useQuery({
    queryKey: ["fluxos", filtro.inicio, filtro.fim],
    queryFn: () => recuperarFluxos(filtro),
  });
};

export default useRecuperarFluxos;