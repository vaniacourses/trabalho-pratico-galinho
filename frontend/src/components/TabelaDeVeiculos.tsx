import dayjs from "dayjs";
import { Link } from "react-router-dom";
import type { Veiculo } from "../interfaces/Veiculo";

interface Props {
  veiculos: Veiculo[];
  
}


const TabelaDeVeiculos = ({ veiculos }: Props) => {
  
  return (
    <div className="overflow-x-auto mb-3">
      <table className="w-full border-2 border-gray-400">
        <thead>
          <tr className="border-2 border-gray-400 bg-gray-300">
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Id</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Placa</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Cliente</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Marca</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Modelo</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Ano</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Cor</th>
          </tr>
        </thead>
        <tbody>
          {veiculos.map((veiculo, index) => (
            <tr key={veiculo.id} className={"border border-gray-200 " + (index % 2 === 0 ? "bg-white" : "bg-gray-100")}>
              <td className="border-r border-r-gray-200 text-center py-1 w-[6%]">
                <Link className="font-bold text-green-700" 
                  to={"/veiculos/" + veiculo.id}>
                  {veiculo.id}
                </Link>
              </td>
              <td className="border-r border-r-gray-200 text-center py-1 w-[12%]">{veiculo.placa}</td>
              <td className="border-r border-r-gray-200 ps-2 py-1 w-[20%]"> {veiculo.cliente.nome} </td>
              <td className="border-r border-r-gray-200 text-center py-1 w-[13%]">{veiculo.marca}</td>
              <td className="border-r border-r-gray-200 text-center py-1 w-[10%]">
                {veiculo.modelo}
              </td>
              <td className="border-r border-r-gray-200 text-center py-1 w-[8%]">{veiculo.ano}</td>
              <td className="border-r border-r-gray-200 text-center py-1 w-[12%]">{veiculo.cor}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
export default TabelaDeVeiculos;