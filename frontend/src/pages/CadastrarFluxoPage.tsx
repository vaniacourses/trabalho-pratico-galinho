import FluxoFormCreate from "../components/FluxoFormCreate";

const CadastrarFluxoPage = () => {
  return (
    <>
      <h1 className="mb-1 text-xl font-semibold">Novo Lançamento no Caixa</h1>
      <hr className="mb-4" />
      <FluxoFormCreate />
    </>
  );
};

export default CadastrarFluxoPage;