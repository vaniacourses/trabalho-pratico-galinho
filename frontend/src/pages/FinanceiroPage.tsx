import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import TabelaDeFluxos from "../components/TabelaDeFluxos";
import useRecuperarFluxos from "../hooks/useRecuperarFluxo";

const FinanceiroPage = () => {
  const navigate = useNavigate();
  
  // Estados para o Filtro de Datas
  const [dataInicio, setDataInicio] = useState("");
  const [dataFim, setDataFim] = useState("");
  const [filtroAtivo, setFiltroAtivo] = useState({ inicio: "", fim: "" });

  // Estado para a busca rápida da O.S.
  const [idOs, setIdOs] = useState("");

  const {
    data: fluxos,
    isPending: recuperandoFluxos,
    error: errorRecuperarFluxos,
  } = useRecuperarFluxos(filtroAtivo);

  if (errorRecuperarFluxos) throw errorRecuperarFluxos;

  const aplicarFiltro = () => setFiltroAtivo({ inicio: dataInicio, fim: dataFim });
  const limparFiltro = () => {
    setDataInicio("");
    setDataFim("");
    setFiltroAtivo({ inicio: "", fim: "" });
  };

  const irParaPagamento = () => {
    if (idOs.trim() !== "") {
      navigate(`/financeiro/pagar/${idOs}`);
    }
  };

  return (
    <>
      <h1 className="mb-1 text-xl font-semibold">Caixa da Oficina</h1>
      <hr className="mb-4" />

      {/* PAINEL DO CAIXA */}
      <div className="mb-6 grid grid-cols-1 md:grid-cols-2 gap-4">
        
        {/* Receber O.S. */}
        <div className="bg-white p-4 rounded-lg border border-gray-200 shadow-sm flex flex-col justify-center">
          <label className="block text-sm font-bold text-gray-800 mb-2">
            <i className="bi bi-receipt"></i> Receber Pagamento de O.S.
          </label>
          <div className="flex gap-2">
            <input 
              type="number" 
              value={idOs}
              onChange={(e) => setIdOs(e.target.value)}
              className="input w-full" 
              placeholder="Digite o Id do Serviço" 
            />
            <button onClick={irParaPagamento} className="bg-blue-600 hover:bg-blue-700 text-white rounded-lg px-4 py-2 font-semibold transition-colors whitespace-nowrap">
              Ir para Checkout
            </button>
          </div>
        </div>

        {/* Saída/Entrada Manual */}
        <div className="bg-white p-4 rounded-lg border border-gray-200 shadow-sm flex flex-col justify-center items-start">
          <label className="block text-sm font-bold text-gray-800 mb-2">
            <i className="bi bi-wallet2"></i> Lançamento Manual no Caixa
          </label>
          <Link className="btn-success px-4 py-2 w-full text-center font-semibold" to={"/financeiro/cadastrar"}>
            <i className="bi bi-plus-circle me-1"></i> Nova Despesa/Entrada
          </Link>
        </div>

      </div>

      {/* BARRA DE FILTROS DO EXTRATO */}
      <h2 className="text-lg font-semibold mb-2">Extrato de Movimentações</h2>
      <div className="mb-4 flex flex-wrap items-end gap-4 bg-gray-50 p-4 rounded-lg border border-gray-200">
        <div>
          <label className="block text-sm font-medium text-gray-700 mb-1">Data Inicial</label>
          <input type="date" value={dataInicio} onChange={(e) => setDataInicio(e.target.value)} className="input bg-white" />
        </div>
        <div>
          <label className="block text-sm font-medium text-gray-700 mb-1">Data Final</label>
          <input type="date" value={dataFim} onChange={(e) => setDataFim(e.target.value)} className="input bg-white" />
        </div>
        <div className="flex gap-2">
          <button onClick={aplicarFiltro} className="btn-success px-4 py-2">
            <i className="bi bi-search me-1"></i> Filtrar
          </button>
          <button onClick={limparFiltro} className="bg-gray-500 hover:bg-gray-600 text-white rounded-lg px-4 py-2 transition-colors">
             Limpar
          </button>
        </div>
      </div>
      
      {/* TABELA DE EXTRATO */}
      {recuperandoFluxos ? (
        <p className="text-lg text-center my-10">Buscando movimentações...</p>
      ) : (
        <TabelaDeFluxos fluxos={fluxos!} />
      )}
    </>
  );
};

export default FinanceiroPage;