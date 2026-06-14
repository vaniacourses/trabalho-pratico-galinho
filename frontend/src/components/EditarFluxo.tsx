import { useEffect } from "react";
import useEditarFluxo from "../hooks/useEditarFluxo";
import useRecuperarFluxoPorId from "../hooks/useRecuperarFluxoPorId";
import { useForm } from "react-hook-form";
import type { FluxoFinanceiroCreate } from "../interfaces/FluxoFinaceiro";

interface Props {
  id: number;
  onClose: () => void;
}

const EditarFluxo = ({ id, onClose }: Props) => {
  const { data: fluxoAtual, isLoading } = useRecuperarFluxoPorId(id);
  const { mutate: salvarEdicao, isPending } = useEditarFluxo();
  
  const { register, handleSubmit, reset, formState: { errors } } = useForm<FluxoFinanceiroCreate>();

  // Quando os dados chegam do back preencher o form
  useEffect(() => {
    if (fluxoAtual) {
      reset({
        titulo: fluxoAtual.titulo,
        descricao: fluxoAtual.descricao,
        valor: fluxoAtual.valor,
        tipo: fluxoAtual.tipo,
        origemOuDestino: fluxoAtual.origemOuDestino,
        // Corta a data para caber no input type="date" (YYYY-MM-DD)
        data: fluxoAtual.data ? fluxoAtual.data.split("T")[0] : "",
      });
    }
  }, [fluxoAtual, reset]);

  const onSubmit = (dadosForm: any) => {
    const valorNumerico = Number(dadosForm.valor);
    const dataFormatada = dadosForm.data.includes("T") 
        ? dadosForm.data 
        : `${dadosForm.data}T12:00:00`;

    const fluxoFormatado = { 
        ...dadosForm, 
        valor: valorNumerico,
        data: dataFormatada 
    };

    salvarEdicao({ id, dados: fluxoFormatado }, {
      onSuccess: () => {
        alert("Movimentação atualizada com sucesso!");
        onClose(); // Fecha o modal após salvar
      },
      onError: (error) => {
        alert(error.message);
      }
    });
  };

  if (isLoading) return <div className="fixed inset-0 bg-black/50 flex items-center justify-center text-white">Carregando...</div>;

  return (
    <div className="fixed inset-0 bg-black/50 flex items-center justify-center p-4 z-50">
      <div className="bg-white p-6 rounded-lg max-w-lg w-full shadow-xl max-h-[90vh] overflow-y-auto">
        <div className="flex justify-between items-center mb-4">
          <h2 className="text-xl font-bold">Editar Movimentação</h2>
          <button onClick={onClose} className="text-gray-500 hover:text-gray-800 font-bold text-xl">&times;</button>
        </div>

        <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
          <div>
            <label className="block mb-1 font-medium">Título</label>
            <input {...register("titulo", { required: true })} className="input w-full" />
          </div>

          <div>
            <label className="block mb-1 font-medium">Descrição</label>
            <textarea {...register("descricao")} className="input w-full resize-none" rows={3}></textarea>
          </div>

          <div className="grid grid-cols-2 gap-4">
            <div>
              <label className="block mb-1 font-medium">Valor (R$)</label>
              <input type="number" step="0.01" {...register("valor", { required: true })} className="input w-full" />
            </div>
            <div>
              <label className="block mb-1 font-medium">Data</label>
              <input type="date" {...register("data", { required: true })} className="input w-full" />
            </div>
            <div>
              <label className="block mb-1 font-medium">Tipo</label>
              <select {...register("tipo")} className="input bg-white w-full">
                <option value="ENTRADA">Entrada</option>
                <option value="SAIDA">Saída</option>
              </select>
            </div>
            <div>
              <label className="block mb-1 font-medium">Origem/Destino</label>
              <input {...register("origemOuDestino", { required: true })} className="input w-full" />
            </div>
          </div>

          <div className="flex gap-2 mt-6">
            <button type="button" onClick={onClose} className="flex-1 py-2 bg-gray-200 text-gray-800 rounded hover:bg-gray-300">Cancelar</button>
            <button type="submit" disabled={isPending} className="flex-1 py-2 btn-success rounded">
              {isPending ? "Salvando..." : "Salvar Alterações"}
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default EditarFluxo;