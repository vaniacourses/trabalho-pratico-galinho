import { Link, NavLink } from "react-router-dom";
//import TabelaDeVeiculos from "../components/TabelaDeVeiculos";
//import useRecuperarVeiculos from "../hooks/useRecuperarVeiculos";
//import useVeiculoStore from "../store/VeiculoStore";
import type { VeiculosUpdate } from "../interfaces/VeiculoUpdate";
import type { Veiculo } from "../interfaces/Veiculo";
import useRecuperarVeiculos from "../hooks/useRecuperarVeiculos";
import TabelaDeVeiculos from "../components/TabelaDeVeiculos";

const VeiculosPage = () => {
  const {
    data: veiculos,
    isPending: recuperandoveiculos,
    error: errorRecuperarveiculos,
  } = useRecuperarVeiculos();

  //const setVeiculoSelecionado = useVeiculoStore((s) => s.setVeiculoSelecionado);




  if (errorRecuperarveiculos) throw errorRecuperarveiculos;

  

  if (recuperandoveiculos) return <p className="text-lg">Recuperando veiculos...</p>;



  return (
    <>
      <h1 className="mb-1 text-xl font-semibold">Lista de Veiculos</h1>
      <hr className="mb-4" />
      <TabelaDeVeiculos veiculos={veiculos}/>
      <div>
        <NavLink
             to="/cadastrar-veiculo"
            //onClick={() => setVeiculoSelecionado({} as Veiculo)}            
            className="btn-success px-2 w-full py-1"
            type="button"
          >
            Cadastrar Novo Veiculo
          </NavLink>
      </div>
    </>
  );
};
export default VeiculosPage;