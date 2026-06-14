import { createBrowserRouter, Navigate } from "react-router-dom";
import ErrorPage from "../pages/ErrorPage";
import HomePage from "../pages/HomePage";
import LoginPage from "../pages/LoginPage";
import Layout from "./Layout";
import ServicosPage from "../pages/ServicosPage";
import ServicosEmAndamentoPage from "../pages/ServicosEmAndamentoPage";
import ServicoPageCliente from "../pages/ServicoPageCliente";
import ServicoPageMecanico from "../pages/ServicoPageMecanico";
import CadastrarServicoPage from "../pages/CadastrarServicoPage";
import CadastroClientePage from "../pages/CadastroClientePage";
import ClientePage from "../pages/ClientePage";
import AlterarClientePage from "../pages/AlterarClientePage";
import LoteProdutoPage from "../pages/LoteProdutoPage";
import CadastrarLoteProdutoPage from "../pages/CadastrarLoteProdutoPage";

const router = createBrowserRouter([
    {
        path: "/",
        element: <Layout />,
        errorElement: <ErrorPage />,
        children: [
            {index: true, element: <Navigate to="/home" replace />},
            {path: "home", element: <HomePage />},
            {path: "login", element: <LoginPage />},
            {path: "cadastro", element: <CadastroClientePage />},
            {path: "servicos", element: <ServicosPage/>},
            {path: "servicosEmProcesso", element: <ServicosEmAndamentoPage/>},
            {path: "servicos/:id", element: <ServicoPageCliente/>},
            {path: "servicos/mecanico/:id", element: <ServicoPageMecanico/>},
            {path: "cadastrar-servico", element: <CadastrarServicoPage/>},
            {path: "clientes/:id", element: <ClientePage />},
            {path: "alterar-cliente", element: <AlterarClientePage />},
            {path: "lote-produto", element: <LoteProdutoPage/>},
            {path: "cadastrar-lote-produto", element: <CadastrarLoteProdutoPage/>}
        ]
    }
])
export default router;