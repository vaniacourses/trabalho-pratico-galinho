import { Link } from "react-router-dom";
import type { LoteProduto } from "../interfaces/LoteProduto";

interface Props {
  loteProdutos: LoteProduto[];
}

const TabelaDeLoteProduto = ({ loteProdutos }: Props) => {
  return (
    <div className="mb-3 overflow-x-auto">
      <h1 className="col-span-4 mb-1 font-bold lg:col-span-3 xl:col-span-2">
        Produtos do Lote
      </h1>
      <table className="w-full border-2 border-gray-400">
        <thead>
          <tr className="border-2 border-gray-400 bg-gray-300">
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">
              ID Lote Produto
            </th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">
              Codigo do Produto
            </th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">
              Nome do Produto
            </th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">
              Fornecedor
            </th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">
              Quantidade
            </th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">
              Validade
            </th>
          </tr>
        </thead>
        <tbody>
          {loteProdutos ? (
            <>
              {loteProdutos.map((loteProduto, index) => (
                <tr
                  key={loteProduto.id}
                  className={
                    "border border-gray-200 " +
                    (index % 2 === 0 ? "bg-white" : "bg-gray-100")
                  }
                >
                  <td className="w-[12%] border-r border-r-gray-200 py-1 text-center">
                    {loteProduto.id}
                  </td>
                  <td className="w-[6%] border-r border-r-gray-200 py-1 text-center">
                    <Link
                      className="font-bold text-green-700"
                      to={"/produtos/" + loteProduto.produto.id}
                    >
                      {loteProduto.produto.codigo}
                    </Link>
                  </td>
                  <td className="w-[12%] border-r border-r-gray-200 py-1 text-center">
                    {loteProduto.produto.nome}
                  </td>
                  <td className="w-[12%] border-r border-r-gray-200 py-1 text-center">
                    <Link
                      className="font-bold text-green-700"
                      to={"/fornecedores/" + loteProduto.fornecedor.id}
                    >
                      {" "}
                      {loteProduto.fornecedor.nome}
                    </Link>
                  </td>
                  <td className="w-[13%] border-r border-r-gray-200 py-1 text-center">
                    {loteProduto.quantidade}
                  </td>
                  <td className="w-[13%] border-r border-r-gray-200 py-1 text-center">
                    {loteProduto.validade}
                  </td>
                </tr>
              ))}
            </>
          ) : (
            <>{}</>
          )}
        </tbody>
      </table>
    </div>
  );
};
export default TabelaDeLoteProduto;
