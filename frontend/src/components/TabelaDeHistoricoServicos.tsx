import dayjs from "dayjs";
import { Link } from "react-router-dom";
import type { Servico } from "../interfaces/Servico";
import type { HistoricoServico } from "../interfaces/HistoricoServico";

interface Props {
  historicos: HistoricoServico[];
}

//const TabelaDeHistoricoServicos = ({ servicos, tratarRemocao, idRemovendo, removendoServico }: Props) => {


//Depois passar a parte de veiculo para Link que envia para a pagina que mostra todos os servicos do veiculo
const TabelaDeHistoricoServicos = ({ historicos }: Props) => {
  let complementoLink = "" //se for mecanico ou + vai para pagina servicos/mecanico
  if(true){complementoLink = "mecanico/"}  //MUDAR AQUI QUANDO FOR POSSIVEL VER ROLE

  return (
    <div className="overflow-x-auto mb-3">
      <table className="w-full border-2 border-gray-400">
        <thead>
          <tr className="border-2 border-gray-400 bg-gray-300">
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Id</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Data</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Descrição</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Status</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Orçamento</th>
          </tr>
        </thead>
        <tbody>
          {historicos.map((historico, index) => (
            <tr key={historico.id} className={"border border-gray-200 " + (index % 2 === 0 ? "bg-white" : "bg-gray-100")}>
              <td className="border-r border-r-gray-200 text-center py-1 w-[6%]"> {historico.id} </td>
              <td className="border-r border-r-gray-200 text-center py-1 w-[12%]">
                {dayjs(historico.date).format("DD/MM/YYYY HH:mm:ss")}
              </td>
              <td className="border-r border-r-gray-200 text-center py-1 w-[20%]">{historico.descricao}</td>
              <td className="border-r border-r-gray-200 text-center py-1 w-[12%]">{historico.statusDoMomento}</td>
              <td className="border-r border-r-gray-200 text-center ps-2 py-1 w-[10%]"> {historico.orcamentoDoMomento} </td>
              {/* <td className="border-r border-r-gray-200 text-center py-1 w-[13%]">{historico.servico.id}</td> */}
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
export default TabelaDeHistoricoServicos;