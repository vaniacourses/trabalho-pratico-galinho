import { useNavigate, useParams } from "react-router-dom";
import dayjs from "dayjs";
// import { useEffect, useState } from "react";
import type { Servico } from "../interfaces/Servico";
import useServicoStore from "../store/ServicoStore";
import TabelaDeProdutos from "../components/TabelaDeProdutos";
import useRecuperarServicoMecanicoPorId from "../hooks/useRecuperarServicoMecanicoPorId";
import TabelaDeTarefas from "../components/TabelaDeTarefas";
import { recuperarTarefas } from "../util/recuperarTarefas";
import useRecuperarHistoricoServico from "../hooks/useRecuperarHistoricoServico";
import TabelaDeHistoricoServicos from "../components/TabelaDeHistoricoServicos";

const ServicoPageCliente = () => {
  // const [removido, setRemovido] = useState(false);
  // const mensagem = useProdutoStore((s) => s.mensagem);
  // const setMensagem = useProdutoStore((s) => s.setMensagem);
  const setServicoSelecionado = useServicoStore((s) => s.setServicoSelecionado);
  const navigate = useNavigate();
  
  const { id } = useParams();

  const {
    data: servico,
    isPending: recuperandoServico,
    error: errorRecuperarServico,
  } = useRecuperarServicoMecanicoPorId(+id!);    //, removido);

  const tratarEdicao = (servico: Servico) => {
    setServicoSelecionado(servico);
    navigate("/cadastrar-servico");
  };

  const {
    data: historico,
    isLoading: buscandoHistorico,
    error: errorRecuperarHistorico,
  } = useRecuperarHistoricoServico(+id!);

  const tarefas = servico?.conjuntoTarefas
    ? recuperarTarefas(servico.conjuntoTarefas)
    : [];

  // const tratarRemocao = (id: number) => {
  //   removerProduto(id);
  //   setRemovido(true);
  //   setMensagem("Produto removido com sucesso!");
  // };

  // const { mutate: removerProduto, 
  //         error: errorRemoverProduto } = useRemoverProduto();

  // useEffect(() => {

  //   return () => {
  //     setMensagem("");
  //   }
  // },[])

  if (errorRecuperarServico) throw errorRecuperarServico;
  // if (errorRemoverProduto) throw errorRemoverProduto;
  if (recuperandoServico || buscandoHistorico)
    return <p className="text-lg">Recuperando servico...</p>;

  return (
    <>
      <h1 className="mb-1 text-xl font-semibold">Página do Serviço</h1>
      <hr className="mb-4" />

      {/* {mensagem && (
        <div className="mb-3 rounded border-2 border-green-600 bg-green-100 px-4 py-3 font-bold text-green-800">
          {mensagem}
        </div>
      )} */}

      {/* 
      Modos do Tailwindcss:
      sm: 640px
      md: 768px
      lg: 1024px
      xl: 1280px
      2xl: 1536px */}

      <div className="grid grid-cols-12">
        {/* <div className="col-span-12 lg:col-span-4 xl:col-span-3"> */}
          {/* Para chegar nessa página o url foi /produtos/:id */}
          {/* Sem a / abaixo seria enviada uma requisição para /produtos/abacate.png*/}
          {/* <img className="lg:hidden" src={"/" + servico.imagem} width="170px" />
          <img
            className="hidden lg:block"
            src={"/" + servico.imagem}
            width="210px"
          /> */}
        {/* </div> */}
        <div className="col-span-12 mb-2 lg:col-span-8 xl:col-span-9">
          <div className="grid grid-cols-12">
            <div className="col-span-4 mb-1 font-bold lg:col-span-3 xl:col-span-2">
              Status
            </div>
            <div className="col-span-8 lg:col-span-9 xl:col-span-10">
              {servico.status}
            </div>

            <div className="col-span-4 mb-1 font-bold lg:col-span-3 xl:col-span-2">
              Descricao
            </div>
            <div className="col-span-8 lg:col-span-9 xl:col-span-10">
              {servico.descricao}
            </div>

            <div className="col-span-4 mb-1 font-bold lg:col-span-3 xl:col-span-2">
              Orçamento
            </div>
            <div className="col-span-8 lg:col-span-9 xl:col-span-10">
              {servico.orcamento.toLocaleString("pt-BR", {
                minimumFractionDigits: 2,
                maximumFractionDigits: 2,
                useGrouping: true,
              })}
            </div>

            <div className="col-span-4 mb-1 font-bold lg:col-span-3 xl:col-span-2">
              Veiculo
            </div>
            <div className="col-span-8 lg:col-span-9 xl:col-span-10">
              {servico.veiculo.placa}
            </div>

            <div className="col-span-4 mb-1 font-bold lg:col-span-3 xl:col-span-2">
              Data Inicio
            </div>
            <div className="col-span-8 lg:col-span-9 xl:col-span-10">
              {dayjs(servico.dataInicio).format("DD/MM/YYYY")}
            </div>

            <div className="col-span-4 mb-1 font-bold lg:col-span-3 xl:col-span-2">
              Data Previsao
            </div>
            <div className="col-span-8 lg:col-span-9 xl:col-span-10">
              {dayjs(servico.dataPrevisao).format("DD/MM/YYYY")}
            </div>

            <div className="col-span-4 mb-1 font-bold lg:col-span-3 xl:col-span-2">
              Data Fim
            </div>
            <div className="col-span-8 lg:col-span-9 xl:col-span-10">
              {dayjs(servico.dataFim).format("DD/MM/YYYY")}
            </div>
            
            <div className="col-span-4 mb-1 font-bold lg:col-span-3 xl:col-span-2">
              Valor Pago
            </div>
            <div className="col-span-8 lg:col-span-9 xl:col-span-10">
              {servico.pagamento ? 
                servico.pagamento.valorFinal.toLocaleString("pt-BR", {
                minimumFractionDigits: 2,
                maximumFractionDigits: 2,
                useGrouping: true,})
                :
                " - "
              }
            </div>
          </div>
        
          { servico.produtosUsados.length!=0 ? <TabelaDeProdutos produtos={servico.produtosUsados}/> : ""}

          {/* <div className="col-span-4 mb-1 font-bold lg:col-span-3 xl:col-span-2">
            Tarefa
          </div>
          <div className="col-span-8 lg:col-span-9 xl:col-span-10">
            { servico.conjuntoTarefas? servico.conjuntoTarefas.descricao : " - "}
          </div> */}

          { tarefas.length!=0 ? <TabelaDeTarefas tarefas={tarefas}/> : ""}  

          { historico.length!= 0 ? 
          <>
            <div className="col-span-4 mb-1 font-bold lg:col-span-3 xl:col-span-2">
              {"Historico"}
            </div>
            <TabelaDeHistoricoServicos historicos={historico} />
          </> : ""
          }

        </div>
        <div className="col-span-4 me-3 xl:col-span-3">
          <button
            onClick={() => tratarEdicao(servico)}
            // disabled={removido}
            className="btn-success w-full py-1"
            type="button"
          >
            Editar
          </button>
        </div>
        {/* <div className="col-span-4 me-3 xl:col-span-3">
          <button
            onClick={() => tratarRemocao(produto.id)}
            disabled={removido}
            className="btn-danger w-full py-1"
            type="button"
          >
            Remover
          </button>
        </div> */}
      </div>
    </>
  );
};
export default ServicoPageCliente;