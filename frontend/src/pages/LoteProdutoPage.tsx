import TabelaDeLoteProdutos from "../components/TabelaDeLoteProdutos";
import useRecuperarProdutos from "../hooks/useRecuperarProdutos";

const EstoquePage = () => {

  const {data: loteProdutos,
        isPending: recuperandoLoteProdutos,
        error: errorRecuperarLoteProdutos} = useRecuperarProdutos();

  if (errorRecuperarLoteProdutos) throw errorRecuperarLoteProdutos;
  if (recuperandoLoteProdutos) return <p className="text-lg">Recuperando lote de produtos...</p>;

  return (
    <>
      <h1 className="text-xl font-semibold mb-1">Lista de Produtos</h1>
      <hr className="mb-4" />
      <TabelaDeLoteProdutos loteProdutos={loteProdutos} />
    </>
  )
}
export default EstoquePage