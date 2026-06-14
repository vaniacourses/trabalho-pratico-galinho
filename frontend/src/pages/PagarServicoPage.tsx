import { useNavigate, useParams } from "react-router-dom";
import useRealizarPagamento from "../hooks/useRealizarPagamento";
import { useState } from "react";
import { useForm } from "react-hook-form";
import useRecuperarServicoClientePorId from "../hooks/useRecuperarServicoClientePorId";

const pagarServicoPage = () => {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();
  const { data: servico, isLoading } = useRecuperarServicoClientePorId(Number(id));
  const { mutate: realizarPagamento, isPending } = useRealizarPagamento();
  const [metodo, setMetodo] = useState<"PIX" | "DINHEIRO" | "CARTAO">("PIX");
  const { register, handleSubmit, reset } = useForm();

  // Troca de método reseta os campos do form
  const handleMudancaMetodo = (novoMetodo: "PIX" | "DINHEIRO" | "CARTAO") => {
    setMetodo(novoMetodo);
    reset(); 
  };

  const onSubmit = (data: any) => {
    // Formata o valor monetário caso seja dinheiro
    if (data.quantiaRecebida) data.quantiaRecebida = Number(data.quantiaRecebida);
    if (data.quantidadeDeParcelas) data.quantidadeDeParcelas = Number(data.quantidadeDeParcelas);

    realizarPagamento({ idServico: Number(id), tipoMetodo: metodo, payload: data }, {
      onSuccess: () => {
        alert("Pagamento registrado com sucesso!");
        navigate("/financeiro"); // Manda para o extrato após pagar
      },
      onError: (error) => {
        alert(error.message);
      }
    });
  };

  if (isLoading) return <div>Carregando...</div>;
  
  return (
    <div className="max-w-2xl mx-auto bg-white p-6 shadow-md rounded-lg">
      <h1 className="mb-1 text-2xl font-bold text-gray-800">Finalizar Serviço #{id}</h1>
      <p className="text-gray-500 mb-4">Selecione a forma de pagamento para dar baixa na O.S.</p>
      <hr className="mb-6" />
      <h1>Finalizar Serviço De Id: {id}</h1>
     {/* DADOS DO CABEÇA */}
      <p>Descrição: {servico?.descricao}</p> 
      <p>Orçamento: R$ {servico?.orcamento}</p>

      {/* Seleção do Método */}
      <div className="flex gap-4 mb-6">
        <button 
          onClick={() => handleMudancaMetodo("PIX")}
          className={`flex-1 py-3 rounded-lg border-2 font-semibold transition-colors ${metodo === "PIX" ? "border-green-600 bg-green-50 text-green-700" : "border-gray-200 text-gray-500 hover:border-gray-300"}`}
        >
          <i className="bi bi-qr-code me-2"></i> PIX
        </button>
        <button 
          onClick={() => handleMudancaMetodo("CARTAO")}
          className={`flex-1 py-3 rounded-lg border-2 font-semibold transition-colors ${metodo === "CARTAO" ? "border-blue-600 bg-blue-50 text-blue-700" : "border-gray-200 text-gray-500 hover:border-gray-300"}`}
        >
          <i className="bi bi-credit-card me-2"></i> Cartão
        </button>
        <button 
          onClick={() => handleMudancaMetodo("DINHEIRO")}
          className={`flex-1 py-3 rounded-lg border-2 font-semibold transition-colors ${metodo === "DINHEIRO" ? "border-yellow-600 bg-yellow-50 text-yellow-700" : "border-gray-200 text-gray-500 hover:border-gray-300"}`}
        >
          <i className="bi bi-cash me-2"></i> Dinheiro
        </button>
      </div>

      <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
        {/* Campo Padrão para todos */}
        <div>
          <label className="block mb-1 font-medium">Título do Recibo</label>
          <input {...register("titulo", { required: true })} className="input" placeholder="Ex: Pagamento Cliente João" defaultValue={`Pagamento O.S. ${id}`} />
        </div>

        {/*Condicionais baseados nos DTOs */}
        {metodo === "PIX" && (
          <div>
            <label className="block mb-1 font-medium">Chave PIX Informada</label>
            <input {...register("chave", { required: true })} className="input" placeholder="CPF, E-mail ou Telefone" />
          </div>
        )}

        {metodo === "CARTAO" && (
          <div className="grid grid-cols-2 gap-4">
            <div>
              <label className="block mb-1 font-medium">Número do Cartão (Somente Dígitos)</label>
              <input {...register("numeroCartao", { required: true, maxLength: 4 })} className="input" placeholder="Ex: 12345678" maxLength={4} />
            </div>
            <div>
              <label className="block mb-1 font-medium">Parcelas</label>
              <select {...register("quantidadeDeParcelas", { required: true })} className="input bg-white">
                {[1, 2, 3, 4, 5, 6, 10, 12].map(num => (
                  <option key={num} value={num}>{num}x</option>
                ))}
              </select>
            </div>
          </div>
        )}

        {metodo === "DINHEIRO" && (
          <div>
            <label className="block mb-1 font-medium">Quantia Recebida </label>
            <div className="relative">
              {/*<span className="absolute left-3 top-2 text-gray-500">R$</span>*/}
              <input type="number" step="0.01" {...register("quantiaRecebida", { required: true, min: 0 })} className="input pl-10" placeholder="0.00R$" />
            </div>
          </div>
        )}

        <button disabled={isPending} className="btn-success w-full py-3 mt-4 text-lg font-bold" type="submit">
          {isPending ? "Processando..." : "Confirmar Pagamento"}
        </button>
      </form>
    </div>
  );
};

export default pagarServicoPage;