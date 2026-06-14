import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import z from "zod";
import { zodResolver } from "@hookform/resolvers/zod";
import useCadastrarCliente from "../hooks/useCadastrarCliente";
import type { Cliente } from "../interfaces/Cliente";

const schema = z.object({
    email: z
        .string()
        .nonempty({ message: "Email não pode estar vazio." })
        .email({ message: "O formato do email é inválido." }),
    senha: z
        .string()
        .nonempty({ message: "Senha não pode estar vazio." }),
    nome: z
        .string()
        .nonempty({ message: "Nome não pode estar vazio." }),
    cpf: z
        .string()
        .nonempty({ message: "CPF não pode estar vazio." })
        .min(11, { message: "O formato do CPF é inválido." })
        .max(11, { message: "O formato do CPF é inválido." }),
    telefone: z
        .string()
        .nonempty({ message: "Telefone não pode estar vazio." })
        .min(11, { message: "O formato do telefone é inválido." })
        .max(11, { message: "O formato do telefone é inválido." }),
    endereco: z
        .string()
        .nonempty({ message: "Endereço não pode estar vazio." })
});

type ClienteForm = z.infer<typeof schema>;

const ClienteForm = () => {
    const {mutate: cadastrarCliente, error: errorCadastrarCliente} = useCadastrarCliente();
    const navigate = useNavigate();

    const {register, handleSubmit, formState: {errors}} = useForm<ClienteForm>({resolver: zodResolver(schema)});
    const submit = ({email, senha, nome, cpf, telefone, endereco}: ClienteForm) => {
        const cliente: Cliente = {
            email: email,
            senha: senha,
            nome: nome,
            cpf: cpf,
            telefone: telefone,
            endereco: endereco
        }
        cadastrarCliente(cliente, {
            onSuccess: () => {
                navigate("/login");
            }
        });
    }
    
    if(errorCadastrarCliente) throw errorCadastrarCliente;

    return (
        <form onSubmit={handleSubmit(submit)} className="mt-6" autoComplete="off">
            <div className="grid grid-cols-12 gap-1 lg:gap-6">
                <div className="col-span-12 lg:col-span-6 mb-1 lg:mb-3">
                    <div className="grid grid-cols-12">
                        <label
                            className="col-span-12 lg:col-span-3 xl:col-span-2 mb-1 flex items-center font-bold"
                            >
                            Email
                        </label>
                        <div className="col-span-12 lg:col-span-9 xl:col-span-10">
                            <input
                                {...register("email")}
                                type="text"
                                className="w-full rounded-md border-2 border-gray-300 bg-white px-2 py-1.5 text-sm text-gray-900 outline-none hover:border-gray-500"
                            />
                            { errors.email && <p className="font-semibold text-sm text-red-700">{errors.email.message}</p> }
                        </div>
                    </div>
                </div> 

                <div className="col-span-12 lg:col-span-6 mb-1 lg:mb-3">
                    <div className="grid grid-cols-12">
                        <label
                            className="col-span-12 lg:col-span-3 xl:col-span-2 mb-1 flex items-center font-bold"
                            >
                            Nome
                        </label>
                        <div className="col-span-12 lg:col-span-9 xl:col-span-10">
                            <input
                                {...register("nome")}
                                type="text"
                                className="w-full rounded-md border-2 border-gray-300 bg-white px-2 py-1.5 text-sm text-gray-900 outline-none hover:border-gray-500"
                            />
                            { errors.nome && <p className="font-semibold text-sm text-red-700">{errors.nome.message}</p> }
                        </div>
                    </div>
                </div>  
            </div>

            <div className="grid grid-cols-12 gap-1 lg:gap-6">
                <div className="col-span-12 lg:col-span-6 mb-1 lg:mb-3">
                    <div className="grid grid-cols-12">
                        <label
                            className="col-span-12 lg:col-span-3 xl:col-span-2 mb-1 flex items-center font-bold"
                            >
                            Senha
                        </label>
                        <div className="col-span-12 lg:col-span-9 xl:col-span-10">
                            <input
                                {...register("senha")}
                                type="text"
                                className="w-full rounded-md border-2 border-gray-300 bg-white px-2 py-1.5 text-sm text-gray-900 outline-none hover:border-gray-500"
                            />
                            { errors.senha && <p className="font-semibold text-sm text-red-700">{errors.senha.message}</p> }
                        </div>
                    </div>
                </div> 

                <div className="col-span-12 lg:col-span-6 mb-1 lg:mb-3">
                    <div className="grid grid-cols-12">
                        <label
                            className="col-span-12 lg:col-span-3 xl:col-span-2 mb-1 flex items-center font-bold"
                            >
                            CPF
                        </label>
                        <div className="col-span-12 lg:col-span-9 xl:col-span-10">
                            <input
                                {...register("cpf")}
                                type="text"
                                className="w-full rounded-md border-2 border-gray-300 bg-white px-2 py-1.5 text-sm text-gray-900 outline-none hover:border-gray-500"
                            />
                            { errors.cpf && <p className="font-semibold text-sm text-red-700">{errors.cpf.message}</p> }
                        </div>
                    </div>
                </div>  
            </div>

            <div className="grid grid-cols-12 gap-1 lg:gap-6">
                <div className="col-span-12 lg:col-span-6 mb-1 lg:mb-3">
                    <div className="grid grid-cols-12">
                        <label
                            className="col-span-12 lg:col-span-3 xl:col-span-2 mb-1 flex items-center font-bold"
                            >
                            Telefone
                        </label>
                        <div className="col-span-12 lg:col-span-9 xl:col-span-10">
                            <input
                                {...register("telefone")}
                                type="text"
                                className="w-full rounded-md border-2 border-gray-300 bg-white px-2 py-1.5 text-sm text-gray-900 outline-none hover:border-gray-500"
                            />
                            { errors.telefone && <p className="font-semibold text-sm text-red-700">{errors.telefone.message}</p> }
                        </div>
                    </div>
                </div> 

                <div className="col-span-12 lg:col-span-6 mb-1 lg:mb-3">
                    <div className="grid grid-cols-12">
                        <label
                            className="col-span-12 lg:col-span-3 xl:col-span-2 mb-1 flex items-center font-bold"
                            >
                            Endereço
                        </label>
                        <div className="col-span-12 lg:col-span-9 xl:col-span-10">
                            <input
                                {...register("endereco")}
                                type="text"
                                className="w-full rounded-md border-2 border-gray-300 bg-white px-2 py-1.5 text-sm text-gray-900 outline-none hover:border-gray-500"
                            />
                            { errors.endereco && <p className="font-semibold text-sm text-red-700">{errors.endereco.message}</p> }
                        </div>
                    </div>
                </div>  
            </div>

            <div className="grid grid-cols-12 gap-1 mb-6">
                <div className="col-span-12 lg:col-span-6 mb-1 lg:mb-3">
                    <div className="grid grid-cols-12">
                        <div className="flex col-span-12 lg:col-start-4 xl:col-start-3">
                            <button
                                type="submit"
                                className="flex justify-center items-center cursor-pointer rounded-md bg-[#e91d25] py-2 font-semibold text-white duration-200 hover:bg-[#d52128] px-5 py-1.5 me-4"
                            >
                                Cadastrar
                            </button>
                        </div>
                    </div>
                </div>  
            </div>
        </form>
    )
}
export default ClienteForm