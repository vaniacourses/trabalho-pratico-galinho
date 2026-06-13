import dayjs from "dayjs";
import useRemoverFluxo from "../hooks/useRemoverFluxo";
import type { FluxoFinanceiro } from "../interfaces/FluxoFinaceiro";

interface Props {
  fluxos: FluxoFinanceiro[];
  // tratarRemocao?: (id: number) => void; -> Adicionaremos na fase de deletar
}

const TabelaDeFluxos = ({ fluxos }: Props) => {
  if (fluxos.length === 0) return <p>Nenhuma movimentação encontrada no caixa.</p>;
  const { mutate: removerFluxo } = useRemoverFluxo();
  return (
    <div className="overflow-x-auto mb-4">
      <table className="min-w-full text-left text-sm whitespace-nowrap">
        <thead className="uppercase tracking-wider border-b-2 border-gray-600">
          <tr>
            <th scope="col" className="px-6 py-4">Data</th>
            <th scope="col" className="px-6 py-4">Título</th>
            <th scope="col" className="px-6 py-4">Tipo</th>
            <th scope="col" className="px-6 py-4">Valor</th>
            <th scope="col" className="px-6 py-4 text-center">Ações</th>
          </tr>
        </thead>
        <tbody>
          {fluxos.map((fluxo) => (
            <tr key={fluxo.id} className="border-b border-gray-300 hover:bg-gray-100">
              <td className="px-6 py-4">{dayjs(fluxo.data).format("DD/MM/YYYY HH:mm")}</td>
              <td className="px-6 py-4 font-medium">{fluxo.titulo}</td>
              <td className="px-6 py-4">
                <span className={`px-2 py-1 rounded text-white text-xs ${fluxo.tipo === 'ENTRADA' ? 'bg-green-600' : 'bg-red-600'}`}>
                  {fluxo.tipo}
                </span>
              </td>
              <td className="px-6 py-4">
                R$ {fluxo.valor.toFixed(2).replace(".", ",")}
              </td>
              <td className="px-6 py-4 text-center">
                <button 
                    onClick={()=> {
                        if(window.confirm("Deseja mesmo excluir esta movimentação?")) removerFluxo(fluxo.id)
                    }}
                    className="text-red-600 hover:text-red-800" title="Excluir"
                    >
                    <i className="bi bi-trash"></i>
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TabelaDeFluxos;