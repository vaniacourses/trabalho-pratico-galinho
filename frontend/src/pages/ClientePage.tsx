import { useNavigate, useParams } from "react-router-dom";
import useRecuperarClientePorId from "../hooks/useRecuperarClientePorId";
import type { Cliente } from "../interfaces/Cliente";
import useClienteStore from "../store/ClienteStore";

const ClientePage = () => {

  const setClienteSelecionado = useClienteStore((s) => s.setClienteSelecionado);
  const navigate = useNavigate();

  const tratarEdicao = (cliente: Cliente) => {
    setClienteSelecionado(cliente);
    navigate("/alterar-cliente");
  }

  const { id } = useParams();

  const {
    data: cliente,
    isPending: recuperandoCliente,
    error: errorRecuperarCliente,
  } = useRecuperarClientePorId(+id!);

  if (errorRecuperarCliente) throw errorRecuperarCliente;
  if (recuperandoCliente)
    return <p className="text-lg">Recuperando...</p>;

  return (
    <>
      <h1 className="mb-1 text-xl font-semibold">Meu Perfil</h1>
      <hr className="mb-4" />

      <div className="grid grid-cols-12">
        <div className="col-span-12 mb-2 lg:col-span-8 xl:col-span-9">
          <div className="grid grid-cols-12">
            <div className="col-span-4 mb-1 font-bold lg:col-span-3 xl:col-span-2">
              Email
            </div>
            <div className="col-span-8 lg:col-span-9 xl:col-span-10">
              {cliente.email}
            </div>

            <div className="col-span-4 mb-1 font-bold lg:col-span-3 xl:col-span-2">
              Nome
            </div>
            <div className="col-span-8 lg:col-span-9 xl:col-span-10">
              {cliente.nome}
            </div>

            <div className="col-span-4 mb-1 font-bold lg:col-span-3 xl:col-span-2">
              CPF
            </div>
            <div className="col-span-8 lg:col-span-9 xl:col-span-10">
              {cliente.cpf}
            </div>

            <div className="col-span-4 mb-1 font-bold lg:col-span-3 xl:col-span-2">
              Telefone
            </div>
            <div className="col-span-8 lg:col-span-9 xl:col-span-10">
              {cliente.telefone}
            </div>

            <div className="col-span-4 mb-1 font-bold lg:col-span-3 xl:col-span-2">
              Endereço
            </div>
            <div className="col-span-8 lg:col-span-9 xl:col-span-10">
              {cliente.endereco}
            </div>
          </div>
        </div>

        <div className="col-span-4 me-3 xl:col-span-3">
          <button
            onClick={() => tratarEdicao(cliente)}
            className="btn-success w-full py-1"
            type="button"
          >
            Editar
          </button>
        </div>
      </div>
    </>
  )
}
export default ClientePage