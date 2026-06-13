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
import FinanceiroPage from "../pages/FinanceiroPage";
import CadastrarFluxoPage from "../pages/CadastrarFluxoPage";
import PagarServicoPage from "../pages/PagarServicoPage";

const router = createBrowserRouter([
    {
        path: "/",
        element: <Layout />,
        errorElement: <ErrorPage />,
        children: [
            {index: true, element: <Navigate to="/home" replace />},
            {path: "home", element: <HomePage />},
            {path: "login", element: <LoginPage />},
            {path: "servicos", element: <ServicosPage/>},
            {path: "servicosEmProcesso", element: <ServicosEmAndamentoPage/>},
            {path: "servicos/:id", element: <ServicoPageCliente/>},
            {path: "financeiro", element: <FinanceiroPage />},
            {path: "financeiro/cadastrar", element: <CadastrarFluxoPage />},
            {path: "financeiro/pagar/:id", element: <PagarServicoPage />},
            {path: "servicos/mecanico/:id", element: <ServicoPageMecanico/>},
            {path: "cadastrar-servico", element: <CadastrarServicoPage/>},
        ]
    }
])
export default router;