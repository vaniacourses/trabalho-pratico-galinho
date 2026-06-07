import { useForm, type FromSubscribe } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import type { Servico } from "../interfaces/Servico";
import type { ServicoCreate } from "../interfaces/ServicoCreate";
import useCadastrarServico from "../hooks/useCadastrarServico";
import { useEffect } from "react";
import useServicoStore from "../store/ServicoStore";
import dayjs from "dayjs";
import type { Mecanico } from "../interfaces/Mecanico";
import type { PagamentoServico } from "../interfaces/PagamentoServico";
import type { ProdutoServico } from "../interfaces/ProdutoServico";
import type { Tarefa } from "../interfaces/Tarefa";
import type { Veiculo } from "../interfaces/Veiculo";
import useAlterarServico from "../hooks/useAlterarServico";
import type { ServicoUpdate } from "../interfaces/ServicoUpdate";
import useBuscarVeiculoPorPlaca from "../hooks/useBuscarVeiculoPorPlaca";

interface FormServico {
  descricao: string;
  orcamento: string;
  veiculoPlaca: string;
  dataPrevisao: string;

  //id?: number;
  status?: string;
  dataInicio?: string;
  dataFim?: string;
  pagamento?: PagamentoServico;
  mecanicos?: Mecanico[];
  veiculo?: Veiculo;
  produtosUsados?: ProdutoServico[];
  conjuntoTarefas?: Tarefa;
}

const ServicoForm = () => {
  //const { register, handleSubmit } = useForm<FormServico>(); 
  const navigate = useNavigate();
  const servicoSelecionado = useServicoStore((s) => s.servicoSelecionado);
  const { mutate: cadastrarServico } = useCadastrarServico();
  //const { mutateAsync: buscarVeiculoPorPlaca } = useBuscarVeiculoPorPlaca();
  const {mutate: alterarServico, error: errorAlterarServico} = useAlterarServico();

  const inicializarForm = () => {
    if (servicoSelecionado.id) {
      //setValue("id", servicoSelecionado.id);
      setValue("status", servicoSelecionado.status);
      setValue("descricao", servicoSelecionado.descricao);
      setValue("orcamento", servicoSelecionado.orcamento.toString());
      setValue("veiculoPlaca", servicoSelecionado.veiculo.placa);
      setValue("dataPrevisao", dayjs(servicoSelecionado.dataPrevisao).format("YYYY-MM-DD"));
      setValue("dataInicio", dayjs(servicoSelecionado.dataInicio).format("YYYY-MM-DD"));
      setValue("dataFim", dayjs(servicoSelecionado.dataFim).format("YYYY-MM-DD"));
      setValue("mecanicos", servicoSelecionado.mecanicos);
      setValue("veiculo", servicoSelecionado.veiculo);
      setValue("pagamento", servicoSelecionado.pagamento);
      setValue("produtosUsados", servicoSelecionado.produtosUsados);
      setValue("conjuntoTarefas", servicoSelecionado.conjuntoTarefas);
    } else {
      reset();
    }
  }


  const { register, handleSubmit ,setValue, reset} = useForm<FormServico>();
  const submit = ({descricao, orcamento, veiculoPlaca, dataPrevisao, status, dataFim}: FormServico) => {
    const servico: ServicoCreate = {
        descricao,
        orcamento: +orcamento,
        veiculoPlaca, //: { id : veiculoId } as any,
        dataPrevisao: `${dataPrevisao}T00:00:00`,
        dataInicio: new Date().toISOString(),
        status: 'A_SER_INICIADO'
    }
    //const veiculo = await buscarVeiculoPorPlaca(veiculoPlaca);
    if(servicoSelecionado.id) {
      //servico.id = servicoSelecionado.id;
      const servicoUpdate: ServicoUpdate = {
        ...servico,
        orcamento: +orcamento || servicoSelecionado.orcamento,
        status: status || servicoSelecionado.status,
        dataInicio: servicoSelecionado.dataInicio,
        dataFim: new Date(dataFim ?? "") || servicoSelecionado.dataFim,
        dataPrevisao: new Date(dataPrevisao) || servicoSelecionado.dataPrevisao,
        id: servicoSelecionado.id,
        veiculo: servicoSelecionado.veiculo,
        pagamento: servicoSelecionado.pagamento
      }
      alterarServico(servicoUpdate, {
          onSuccess: (servicoUpdate: ServicoUpdate) => {
              //setMensagem("Produto alterado com sucesso.");
              navigate("/servicos/" + servicoUpdate.id);
          }
        });
      } else {
        cadastrarServico(servico, {
          onSuccess: (servico: Servico) => {
            //setMensagem("Produto cadastrado com sucesso.");
            navigate("/servicos/" + servico.id);
          }
        });
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

    // cadastrarServico(servico, {
    //   onSuccess: (servico: Servico) => {
    //     navigate("/servicos/" + servico.id);
    //   },
    // });
  };

  useEffect(() => {
    if (servicoSelecionado?.id) {
      inicializarForm();
    }
  }, [servicoSelecionado])

  return (
    <form onSubmit={handleSubmit(submit)} className="mt-6">

      <p className="">{"Descrição"}</p>
      <input
        {...register("descricao")}
        placeholder="Descrição"
        className="input mb-2"
      />

      <p className="">{"Orçamento"}</p>
      <input
        {...register("orcamento")}
        // type="number"
        placeholder="orçamento"
        className="input mb-2"
      />

      { servicoSelecionado.veiculo? "" :
      <>
      <p className="">{"Veículo"}</p>
      <input
        {...register("veiculoPlaca")}//, { valueAsNumber: true })}
        // type="number"
        placeholder="Placa Veiculo"
        className="input mb-2"
      /></>}

      <p className="">{"Data Previsao"}</p>
      <input
        {...register("dataPrevisao")}
        type="date"
        className="input mb-2"
      />

      { servicoSelecionado.status ?
      <>
      <p className="">{"Status"}</p>
      <input
        {...register("status")}//, { valueAsNumber: true })}
        // type="number"
        placeholder="status"
        className="input mb-2"
      />
      </> : ""}

      { servicoSelecionado.status ?
      <>
      <p className="">{"dataFim"}</p>
      <input
        {...register("dataFim")}//, { valueAsNumber: true })}
        type="date"
        placeholder="Data Fim"
        className="input mb-2"
      />
      </> : ""}

      <button type="submit" className="btn-success px-5 py-1 mt-4">
        {servicoSelecionado.status ? "Atualizar Serviço" : "Criar Serviço"}
      </button>
    </form>
  );
};

export default ServicoForm;