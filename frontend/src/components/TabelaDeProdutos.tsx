import dayjs from "dayjs";
import { Link } from "react-router-dom";
import type { ProdutoServico } from "../interfaces/ProdutoServico";

interface Props {
  produtos: ProdutoServico[];
  //tratarRemocao: (id: number) => void;
  
  //idRemovendo?: number | null;
  
  
  //removendoproduto?: boolean;
}

//const TabelaDeProdutos = ({ produtos, tratarRemocao, idRemovendo, removendoproduto }: Props) => {


//Depois passar a parte de veiculo para Link que envia para a pagina que mostra todos os produtos do veiculo
const TabelaDeProdutos = ({ produtos }: Props) => {
  return (
    <div className="overflow-x-auto mb-3">
      <h1 className="col-span-4 mb-1 font-bold lg:col-span-3 xl:col-span-2" >Produtos Usados</h1>
      <table className="w-full border-2 border-gray-400">
        <thead>
          <tr className="border-2 border-gray-400 bg-gray-300">
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Codigo</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Nome</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Preco</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Quantidade</th>
            <th className="border-r border-r-gray-200 p-1.5 font-semibold">Descricao</th>
          </tr>
        </thead>
        <tbody>
          {produtos ?
            <>
            {produtos.map((produto, index) => (
              <tr key={produto.id} className={"border border-gray-200 " + (index % 2 === 0 ? "bg-white" : "bg-gray-100")}>
                <td className="border-r border-r-gray-200 text-center py-1 w-[6%]">
                  <Link className="font-bold text-green-700" to={"/produtos/" + produto.id}>{produto.produto.codigo}</Link>
                </td>
                <td className="border-r border-r-gray-200 text-center py-1 w-[12%]">{produto.produto.nome}</td>
                <td className="border-r border-r-gray-200 ps-2 py-1 w-[20%]"> {produto.precoDoMomento} </td>
                <td className="border-r border-r-gray-200 text-center py-1 w-[13%]">{produto.quantidade}</td>
                <td className="border-r border-r-gray-200 text-center py-1 w-[13%]">{produto.produto.descricao}</td>
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
export default TabelaDeProdutos;