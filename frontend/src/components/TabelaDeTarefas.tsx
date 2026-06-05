import dayjs from "dayjs";
import { Link } from "react-router-dom";
import type { Tarefa } from "../interfaces/Tarefa";

interface Props {
  tarefas: Tarefa[];
  //tratarRemocao: (id: number) => void;
  
  //idRemovendo?: number | null;
  
  
  //removendotarefa?: boolean;
}

//const TabelaDeTarefas = ({ tarefas, tratarRemocao, idRemovendo, removendotarefa }: Props) => {


//Depois passar a parte de veiculo para Link que envia para a pagina que mostra todos os tarefas do veiculo
const TabelaDeTarefas = ({ tarefas }: Props) => {
  return (
    <div className="overflow-x-auto mb-3">
      <h1 className="col-span-4 mb-1 font-bold lg:col-span-3 xl:col-span-2" >Tarefas</h1>
      <table className="w-full border-2 border-gray-400">
        <thead>
          <tr className="border-2 border-gray-400 bg-gray-300">
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">ID</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Descricao</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Valor</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Data</th>
          </tr>
        </thead>
        <tbody>
          {tarefas ?
            <>
            {tarefas.map((tarefa, index) => (
              <tr key={tarefa.id} className={"border border-gray-200 " + (index % 2 === 0 ? "bg-white" : "bg-gray-100")}>
                <td className="border-r border-r-gray-200 text-center py-1 w-[3%]">
                  {/* <Link className="font-bold text-green-700" to={"/tarefas/" + tarefa.id}>{tarefa.id}</Link> */}
                    {tarefa.id}
                </td>
                <td className="border-r border-r-gray-200 text-center py-1 w-[30%]">{tarefa.descricao}</td>
                <td className="border-r border-r-gray-200 text-center ps-2 py-1 w-[5%]"> {tarefa.valor} </td>
                <td className="border-r border-r-gray-200 text-center py-1 w-[5%]">{dayjs(tarefa.data).format("DD/MM/YYYY")}</td>
              </tr>
            ))}
            </>
            :
            <>{}</>
          } 
        </tbody>
      </table>
    </div>
  );
};
export default TabelaDeTarefas;