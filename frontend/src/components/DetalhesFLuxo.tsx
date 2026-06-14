import useRecuperarFluxoPorId from "../hooks/useRecuperarFluxoPorId";

interface Props {
  id: number;
  onClose: () => void;
}

const DetalhesFluxo = ({ id, onClose }: Props) => {
  const { data: fluxo, isLoading } = useRecuperarFluxoPorId(id);

  if (isLoading) return <div className="fixed inset-0 bg-black/50 flex items-center justify-center">Carregando...</div>;

  return (
    <div className="fixed inset-0 bg-black/50 flex items-center justify-center p-4">
      <div className="bg-white p-6 rounded-lg max-w-md w-full shadow-xl">
        <h2 className="text-xl font-bold mb-4">Detalhes do Fluxo</h2>
        <div className="space-y-2 text-gray-700">
          <p><strong>Título:</strong> {fluxo?.titulo}</p>
          <div className="max-h-40 overflow-y-auto p-2 border border-gray-100 rounded bg-gray-50">
            <p className="break-words text-sm text-gray-700">
            <strong>Descrição:</strong> {fluxo?.descricao}
            </p>
          </div>
          <p><strong>Data:</strong> {new Date(fluxo?.data!).toLocaleString()}</p>
          <p><strong>Valor:</strong> R$ {fluxo?.valor.toFixed(2)}</p>
          <p><strong>Origem/Destino:</strong> {fluxo?.origemOuDestino}</p>
        </div>
        <button onClick={onClose} className="mt-6 w-full btn-success py-2">Fechar</button>
      </div>
    </div>
  );
};

export default DetalhesFluxo