import { useState } from 'react'; // Importe o useState
import dayjs from "dayjs";
import useRemoverFluxo from "../hooks/useRemoverFluxo";
import type { FluxoFinanceiro } from "../interfaces/FluxoFinaceiro";
import DetalhesFluxo from "./DetalhesFLuxo";
import EditarFluxo from './EditarFluxo';

interface Props {
  fluxos: FluxoFinanceiro[];
}

const TabelaDeFluxos = ({ fluxos }: Props) => {
  if (fluxos.length === 0) return <p>Nenhuma movimentação encontrada no caixa.</p>;
  
  const [detalheId, setDetalheId] = useState<number | null>(null);
  const [editId, setEditId] = useState<number | null>(null); 
  
  const { mutate: removerFluxo } = useRemoverFluxo();

  return (
    <>
      <div className="overflow-x-auto mb-4">
        <table className="min-w-full text-left text-sm whitespace-nowrap">
          <tbody>
            {fluxos.map((fluxo) => (
              <tr 
                key={fluxo.id} 
                className="border-b border-gray-300 hover:bg-gray-100 cursor-pointer"
                onClick={() => setDetalheId(fluxo.id)}
              >
                <td className="px-6 py-4">{dayjs(fluxo.data).format("DD/MM/YYYY HH:mm")}</td>
                <td className="px-6 py-4 font-medium">{fluxo.titulo}</td>
                <td className="px-6 py-4">
                  <span className={`px-2 py-1 rounded text-white text-xs ${fluxo.tipo === 'ENTRADA' ? 'bg-green-600' : 'bg-red-600'}`}>
                    {fluxo.tipo}
                  </span>
                </td>
                <td className="px-6 py-4">R$ {fluxo.valor.toFixed(2).replace(".", ",")}</td>
                
                {/* Impede a propagação do clique aqui */}
                <td className="px-6 py-4 text-center">
                  <button 
                    onClick={(e) => {
                      e.stopPropagation(); // Corta o clique aqui, direto no botão!
                      setEditId(fluxo.id);
                    }} 
                    className="text-blue-600 mr-3 hover:text-blue-800" 
                    title="Editar"
                  >
                    <i className="bi bi-pencil"></i>
                  </button>
                  
                  <button 
                    onClick={(e) => {
                        e.stopPropagation(); // Corta o clique aqui também!
                        if(window.confirm("Deseja mesmo excluir esta movimentação?")) removerFluxo(fluxo.id)
                    }}
                    className="text-red-600 hover:text-red-800" 
                    title="Excluir"
                  >
                    <i className="bi bi-trash"></i>
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

     {detalheId && (
        <DetalhesFluxo id={detalheId} onClose={() => setDetalheId(null)} />
      )}
      
      {/* O novo modal de edição */}
      {editId && (
        <EditarFluxo id={editId} onClose={() => setEditId(null)} />
      )}
    </>
  );
};

export default TabelaDeFluxos;