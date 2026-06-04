import dayjs from "dayjs";
import { Link } from "react-router-dom";
import type { Servico } from "../interfaces/Servico";

interface Props {
  servicos: Servico[];
  //tratarRemocao: (id: number) => void;
  
  //idRemovendo?: number | null;
  
  
  //removendoServico?: boolean;
}

//const TabelaDeServicos = ({ servicos, tratarRemocao, idRemovendo, removendoServico }: Props) => {


//Depois passar a parte de veiculo para Link que envia para a pagina que mostra todos os servicos do veiculo
const TabelaDeServicos = ({ servicos }: Props) => {
  return (
    <div className="overflow-x-auto mb-3">
      <table className="w-full border-2 border-gray-400">
        <thead>
          <tr className="border-2 border-gray-400 bg-gray-300">
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Id</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Status</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Descricao</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">orcamento</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Veiculo</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Cliente</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">DataInicio</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">DataFim</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">ValorPago</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Ação</th>
          </tr>
        </thead>
        <tbody>
          {servicos.map((servico, index) => (
            <tr key={servico.id} className={"border border-gray-200 " + (index % 2 === 0 ? "bg-white" : "bg-gray-100")}>
              <td className="border-r border-r-gray-200 text-center py-1 w-[6%]">
                <Link className="font-bold text-green-700" to={"/servicos/" + servico.id}>{servico.id}</Link>
              </td>
              <td className="border-r border-r-gray-200 text-center py-1 w-[12%]">{servico.status}</td>
              <td className="border-r border-r-gray-200 ps-2 py-1 w-[20%]"> {servico.descricao} </td>
              <td className="border-r border-r-gray-200 text-center py-1 w-[13%]">{servico.orcamento}</td>
              <td className="border-r border-r-gray-200 text-center py-1 w-[13%]">
                {servico.veiculo.placa}
              </td>
              <td className="border-r border-r-gray-200 text-center py-1 w-[8%]">{servico.veiculo.cliente.nome}</td>
              <td className="border-r border-r-gray-200 text-center py-1 w-[12%]">{dayjs(servico.dataInicio).format("DD/MM/YYYY")}</td>
              <td className="border-r border-r-gray-200 text-center py-1 w-[12%]">{ servico.dataFim ? 
                dayjs(servico.dataFim).format("DD/MM/YYYY")
                :
                " - "
                }
              </td>
              <td className="border-r border-r-gray-200 text-end pe-2 py-1 w-[10%]">{servico.pagamento ? servico.pagamento.valorFinal.toLocaleString("pt-BR", {
                minimumFractionDigits: 2,
                maximumFractionDigits: 2,
                useGrouping: true})
                :
                ""}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
export default TabelaDeServicos;