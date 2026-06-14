import { NavLink } from "react-router-dom";
import TabelaDeLoteProdutos from "../components/TabelaDeLoteProdutos";
import useRecuperarLoteProdutos from "../hooks/useRecuperarLoteProdutos";

const LoteProdutoPage = () => {
  const {
    data: loteProdutos,
    isPending: recuperandoLoteProdutos,
    error: errorRecuperarLoteProdutos,
  } = useRecuperarLoteProdutos();

  if (errorRecuperarLoteProdutos) throw errorRecuperarLoteProdutos;
  if (recuperandoLoteProdutos)
    return <p className="text-lg">Recuperando lote de produtos...</p>;

  return (
    <>
      <h1 className="mb-1 text-xl font-semibold">Lista de Produtos</h1>
      <hr className="mb-4" />
      <TabelaDeLoteProdutos loteProdutos={loteProdutos} />
      <div>
        {/* <Link className="btn-success px-2 py-1" to={"/cadastrar-servico"}>Cadastrar Novo Serviço</Link> */}
        <NavLink
          to="/cadastrar-lote-produto"
          //onClick={() => setServicoSelecionado({} as Servico)}
          // disabled={removido}
          className="btn-success w-full px-2 py-1"
          type="button"
        >
          Cadastrar Novo Serviço
        </NavLink>
      </div>
    </>
  );
};
export default LoteProdutoPage;
