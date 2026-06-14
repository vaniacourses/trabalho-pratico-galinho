import { useForm } from "react-hook-form";
import type { Usuario } from "../interfaces/Usuario";
import useUsuarioStore from "../store/UsuarioStore";
import { useLocation, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import useEfetuarLogin from "../hooks/useEfetuarLogin";
import type { LoginResponse } from "../interfaces/LoginResponse";

interface LoginForm {
  email: string;
  senha: string;
}

const LoginPage = () => {

  const setUsuarioLogado = useUsuarioStore((s) => s.setUsuarioLogado);
  const setRoleUsuarioLogado = useUsuarioStore((s) => s.setRoleUsuarioLogado);
  const [loginInvalido, setLoginInvalido] = useState(false);

  const location = useLocation();
  const navigate = useNavigate();

  const {register, handleSubmit} = useForm<LoginForm>();

  const {mutate: efetuarLogin,
         error: errorEfetuarLogin} = useEfetuarLogin();

  useEffect(() => {
    setUsuarioLogado(0);
    setRoleUsuarioLogado("");
  }, [])

  const submit = ({email, senha}: LoginForm) => {
    const usuario: Usuario = {email, senha};
    efetuarLogin(usuario, {
      onSuccess: (loginResponse: LoginResponse) => {
        if (loginResponse.id) {
          setUsuarioLogado(loginResponse.id);
          setRoleUsuarioLogado(loginResponse.role);
          if (location.state?.destino) {
            navigate(location.state.destino);
          }
          else {
            navigate("/");
          }
        }
        else {
          setLoginInvalido(true);
        }
      }
    })
  }

  if (errorEfetuarLogin) throw errorEfetuarLogin;

  return (
    <>
      <div className="mt-12 flex justify-center bg-white">
        <div className="w-full max-w-md space-y-6 rounded-2xl bg-white p-8 shadow-2xl duration-300">
          <h2 className="text-center text-2xl font-bold text-gray-800">
            Login
          </h2>
          {loginInvalido && (
            <div className="mb-3 rounded border-2 border-red-600 bg-red-100 px-4 py-3 font-bold text-red-800">
              Login inválido.
            </div>
          )}	
          <form onSubmit={handleSubmit(submit)} className="space-y-4">
            <div>
              <label
                className="mb-1 block text-sm font-medium text-gray-700"
              >
                Email
              </label>
              <input
                {...register("email")}
                type="text"
                placeholder="Informe seu email"
                className="w-full rounded-md border-2 border-gray-300 bg-white px-4 py-2 text-gray-900 outline-none hover:border-gray-500"
              />
            </div>
            <div>
              <label
                className="mb-1 block text-sm font-medium text-gray-700"
              >
                Senha
              </label>
              <input
                {...register("senha")}
                type="password"
                placeholder="Informe sua senha"
                className="w-full rounded-md border-2 border-gray-300 bg-white px-4 py-2 text-gray-900 outline-none hover:border-gray-500"
              />
            </div>
            <button
              type="submit"
              className="w-full cursor-pointer rounded-md bg-[#e91d25] py-2 font-semibold text-white duration-200 hover:bg-[#d52128]"
            >
              Entrar
            </button>
          </form>
          
          <p className="text-center text-sm text-gray-500">
            <span className="me-1">Não possui conta?</span>
            <a href="/cadastro" className="text-[#e91d25] hover:underline">
              Cadastre-se
            </a>
          </p>
        </div>
      </div>
    </>
  );
};
export default LoginPage;
