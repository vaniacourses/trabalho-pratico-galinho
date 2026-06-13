import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import type { Servico } from "../interfaces/Servico";
import type { ServicoCreate } from "../interfaces/ServicoCreate";
import useCadastrarServico from "../hooks/useCadastrarServico";

interface FormServico {
  descricao: string;
  orcamento: string;
  veiculoPlaca: string;
  dataPrevisao: string;
}

const ServicoFormCreate = () => {
  //const { register, handleSubmit } = useForm<FormServico>();  const navigate = useNavigate();
  const { mutate: cadastrarServico } = useCadastrarServico();

  const submit = ({ descricao, orcamento, veiculoPlaca, dataPrevisao }: FormServico) => {
    const servico: ServicoCreate = {
        descricao,
        orcamento: +orcamento,
        veiculoPlaca, //: { id : veiculoId } as any,
        dataPrevisao: `${dataPrevisao}T00:00:00`,
        dataInicio: new Date().toISOString(),
        status: 'A_SER_INICIADO'
    };

    // Long id,
    // TipoStatus status,
    // LocalDateTime dataInicio,
    // LocalDateTime dataFim,
    // LocalDateTime dataPrevisao,
    // String descricao,
    // BigDecimal orcamento,
    // PagamentoServico pagamento,
    // Veiculo veiculo

    cadastrarServico(servico, {
      onSuccess: (servico: Servico) => {
        navigate("/servicos/" + servico.id);
      },
    });
  };

  return (
    <form onSubmit={handleSubmit(submit)} className="mt-6">

      <input
        {...register("descricao")}
        placeholder="Descrição"
        className="input mb-2"
      />

      <input
        {...register("orcamento")}
        type="number"
        placeholder="Orçamento"
        className="input mb-2"
      />

      <input
        {...register("veiculoPlaca")}//, { valueAsNumber: true })}
        // type="number"
        placeholder="Placa Veiculo"
        className="input mb-2"
      />

      <p className="">{"Data Previsao"}</p>
      <input
        {...register("dataPrevisao")}
        type="date"
        className="input mb-2"
      />

      <button type="submit" className="btn-success px-5 py-1 mt-4">
        Criar Serviço
      </button>
    </form>
  );
};

export default ServicoFormCreate;