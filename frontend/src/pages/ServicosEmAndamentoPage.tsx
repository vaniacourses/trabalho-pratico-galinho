
// import useRemoverProdutoOtimista from "../hooks/useRemoverProdutoOtimista";

import TabelaDeServicos from "../components/TabelaDeServicos";
import useRecuperarServicosEmProcesso from "../hooks/useRecuperarServicosEmProcesso";
import useRemoverServicoOtimista from "../hooks/useRemoverServicoOtimista";

const ServicosEmAndamentoPage = () => {
  const {
    data: servicos,
    isPending: recuperandoservicos,
    error: errorRecuperarservicos,
  } = useRecuperarServicosEmProcesso();

//   const tratarRemocao = (id: number) => {
//     removerServico(id);
//   };

//   const { mutate: removerServico,
//           isPending: removendoServico
//        // error: errorRemoverServico  <== Isso não pode existir com remoção otimista
//        // caso contrário a página de erro será exibida. Veja abaixo.
//   } = useRemoverServicoOtimista();

  if (errorRecuperarservicos) throw errorRecuperarservicos;

  // Ao utiizar a remoção otimista errorRemoverProduto não deve ser utilizado para que a 
  // página de erro não seja exibida.
  // if (errorRemoverProduto) throw errorRemoverProduto;

  if (recuperandoservicos) return <p className="text-lg">Recuperando servicos...</p>;

  //<TabelaDeServicos servicos={servicos} tratarRemocao={tratarRemocao} removendoServico={removendoServico} />


  return (
    <>
      <h1 className="mb-1 text-xl font-semibold">Lista de servicos</h1>
      <hr className="mb-4" />
      <TabelaDeServicos servicos={servicos}/>
    </>
  );
};
export default ServicosEmAndamentoPage;