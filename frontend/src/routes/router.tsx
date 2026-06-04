import { createBrowserRouter, Navigate } from "react-router-dom";
import ErrorPage from "../pages/ErrorPage";
import HomePage from "../pages/HomePage";
import LoginPage from "../pages/LoginPage";
import Layout from "./Layout";
import ServicosPage from "../pages/ServicosPage";
import ServicosEmAndamentoPage from "../pages/ServicosEmAndamentoPage";
import ServicoPage from "../pages/ServicoPage";

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
            {path: "servicos/:id", element: <ServicoPage/>}
        ]
    }
])
export default router;