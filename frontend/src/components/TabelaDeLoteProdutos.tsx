import dayjs from "dayjs";
import { Link } from "react-router-dom";
import type { LoteProduto } from "../interfaces/LoteProduto";
import useRecuperarLoteProduto from "../hooks/useRecuperarLoteProdutos";

interface Props {
  loteProdutos: LoteProduto[];
}

const TabelaDeLoteProduto = ({ loteProdutos }: Props) => {
  return (
    <div className="overflow-x-auto mb-3">
      <h1 className="col-span-4 mb-1 font-bold lg:col-span-3 xl:col-span-2" >Produtos do Lote</h1>
      <table className="w-full border-2 border-gray-400">
        <thead>
          <tr className="border-2 border-gray-400 bg-gray-300">
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Codigo Lote</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Validade</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Quantidade</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Descricao</th>
          </tr>
        </thead>
        <tbody>
          {loteProdutos ?
            <>
            {loteProdutos.map((loteProduto, index) => (
              <tr key={loteProduto.id} className={"border border-gray-200 " + (index % 2 === 0 ? "bg-white" : "bg-gray-100")}>
                <td className="border-r border-r-gray-200 text-center py-1 w-[6%]">
                  <Link className="font-bold text-green-700" to={"/produtos/" + loteProduto.produto.id}>{loteProduto.produto.codigo}</Link>
                </td>
                <td className="border-r border-r-gray-200 text-center py-1 w-[12%]">{loteProduto.produto.nome}</td>
                <td className="border-r border-r-gray-200 ps-2 py-1 w-[20%]"> {loteProduto.codigoLote} </td>
                <td className="border-r border-r-gray-200 text-center py-1 w-[13%]">{loteProduto.validade}</td>
                <td className="border-r border-r-gray-200 text-center py-1 w-[13%]">{loteProduto.produto.descricao}</td>
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
export default TabelaDeLoteProduto;