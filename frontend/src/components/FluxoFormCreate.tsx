import { useNavigate } from "react-router-dom";
import type { FluxoFinanceiroCreate } from "../interfaces/FluxoFinaceiro";
import useAdicionarFluxo from "../hooks/useAdicionarFluxo";
import { useForm } from "react-hook-form";

const FluxoFormCreate = () => {
  const { register, handleSubmit, formState: { errors } } = useForm<FluxoFinanceiroCreate>();
  const { mutate: adicionar, isPending } = useAdicionarFluxo();
  const navigate = useNavigate();

  const onSubmit = (data: FluxoFinanceiroCreate) => {
    // Converte a string do input para número
    const fluxoFormatado = { ...data, valor: Number(data.valor) };
    
    adicionar(fluxoFormatado, {
      onSuccess: () => {
        navigate("/financeiro"); // Volta para a tabela após salvar
      },
      onError: (error) => {
        alert(error.message);
      }
    });
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)} className="space-y-4 max-w-lg">
      <div>
        <label className="block mb-1 font-medium">Título da Movimentação</label>
        <input 
          {...register("titulo", { required: "O título é obrigatório" })} 
          className="input" 
          placeholder="Ex: Compra de Óleo" 
        />
        {errors.titulo && <span className="text-red-500 text-sm">{errors.titulo.message}</span>}
      </div>

      <div>
        <label className="block mb-1 font-medium">Descrição</label>
        <input 
          {...register("descricao")} 
          className="input" 
          placeholder="Ex: 5 litros de óleo 5W40" 
        />
      </div>

      <div className="grid grid-cols-2 gap-4">
        <div>
          <label className="block mb-1 font-medium">Valor (R$)</label>
          <input 
            type="number" 
            step="0.01" 
            {...register("valor", { required: "Valor obrigatório", min: 0.1 })} 
            className="input" 
            placeholder="0.00" 
          />
          {errors.valor && <span className="text-red-500 text-sm">{errors.valor.message}</span>}
        </div>

        <div>
          <label className="block mb-1 font-medium">Tipo</label>
          <select {...register("tipo")} className="input bg-white">
            <option value="ENTRADA">Entrada</option>
            <option value="SAIDA">Saída</option>
          </select>
        </div>
      </div>

      <div>
        <label className="block mb-1 font-medium">Origem ou Destino</label>
        <input 
          {...register("origemOuDestino", { required: "Obrigatório" })} 
          className="input" 
          placeholder="Ex: Autopeças Central" 
        />
      </div>

      <button disabled={isPending} className="btn-success w-full py-2 mt-4" type="submit">
        {isPending ? "Salvando..." : "Salvar Lançamento"}
      </button>
    </form>
  );
};

export default FluxoFormCreate;