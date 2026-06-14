import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import useCadastrarLoteProduto from "../hooks/useCadastrarLoteProduto";
import type { Fornecedor } from "../interfaces/Fornecedor";
import type { Produto } from "../interfaces/Produto";
import type { LoteProdutoCreate } from "../interfaces/LoteProdutoCreate";
import type { LoteProduto } from "../interfaces/LoteProduto";

interface FormLoteProduto {
  quantidade: string;
  validade: string;
  codigoLote: string;
  fornecedorId: number;
  produtoId: number;
}

const LoteProdutoFormCreate = () => {
  const { register, handleSubmit } = useForm<FormLoteProduto>();
  const navigate = useNavigate();
  const { mutate: cadastrarLoteProduto } = useCadastrarLoteProduto();

  const submit = ({
    quantidade,
    validade,
    codigoLote,
    fornecedorId,
    produtoId,
  }: FormLoteProduto) => {
    const loteProduto: LoteProdutoCreate = {
      id: null,
      quantidade: +quantidade,
      validade: `${validade}T00:00:00`,
      codigoLote,
      fornecedorId: +fornecedorId,
      produtoId: +produtoId,
    };
    cadastrarLoteProduto(loteProduto, {
      onSuccess: (loteProduto: LoteProduto) => {
        navigate("/lote-produto/" + loteProduto.id);
      },
    });
  };

  return (
    <form onSubmit={handleSubmit(submit)} className="mt-6">
      <input
        {...register("quantidade")}
        placeholder="Quantidade"
        className="input mb-2"
      />

      <input
        {...register("validade")}
        type="date"
        placeholder="Validade"
        className="input mb-2"
      />

      <input
        {...register("codigoLote")} //, { valueAsNumber: true })}
        type="number"
        placeholder="Código do Lote"
        className="input mb-2"
      />

      <input
        {...register("fornecedorId")}
        type="number"
        placeholder="fornecedor"
        className="input mb-2"
      />

      <input
        {...register("produtoId")}
        type="number"
        placeholder="produto"
        className="input mb-2"
      />

      <button type="submit" className="btn-success mt-4 px-5 py-1">
        Criar Lote Produto
      </button>
    </form>
  );
};

export default LoteProdutoFormCreate;
