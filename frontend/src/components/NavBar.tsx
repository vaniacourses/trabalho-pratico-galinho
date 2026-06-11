import { NavLink } from "react-router-dom";
import galinho from "../assets/galinho.png";
import "bootstrap-icons/font/bootstrap-icons.min.css";
import { useState } from "react";

// Modos do Tailwindcss:
// sm: 640px
// md: 768px
// lg: 1024px
// xl: 1280px
// 2xl: 1536px

const NavBar = () => {
  const [isOpen, setIsOpen] = useState(false);
  const [servicosOpen, setServicosOpen] = useState(false);

  return (
    <nav className="mb-6 bg-gray-100 py-4">
      <div className="mx-3 md:mx-10 lg:mx-20">
        <div className="flex justify-between">
          <div className="flex items-center space-x-4">
            <NavLink className="me-10" to="/" onClick={() => setIsOpen(false)}>
              <img src={galinho} width="45px" />
            </NavLink>
            <NavLink
              className="hidden text-gray-700 hover:text-black md:block"
              aria-current="page"
              to="/"
            >
              <i className="bi bi-house me-1"></i>
              Home
            </NavLink>


            <div className="relative">
              <button
                onClick={() => setServicosOpen(!servicosOpen)}
                className="text-gray-700 hover:text-black"
              >
                <i className="bi bi-card-checklist me-1"></i>
                Serviços {servicosOpen ? "▲" : "▼"}
              </button>

              {servicosOpen && (
                <div className="absolute left-0 mt-2 w-56 rounded-md border bg-white shadow-lg">
                  <NavLink
                    className="block px-4 py-2 text-gray-700 hover:bg-gray-100"
                    to="/servicos"
                  >
                    <i className="bi bi-card-checklist me-1"></i>
                    Serviços
                  </NavLink>

                  <NavLink
                    className="block px-4 py-2 text-gray-700 hover:bg-gray-100"
                    to="/servicosEmProcesso"
                  >
                    <i className="bi bi-card-list me-1"></i>
                    Serviços Em Processo
                  </NavLink>
                  
                </div>
              )}
            </div>


            
          </div>

          <div className="flex items-center space-x-4">
            <NavLink className="text-gray-700 hover:text-black" to="/login">
              <i className="bi bi-box-arrow-in-right me-1"></i>
              Entrar
            </NavLink>
          </div>

          <button
            onClick={() => setIsOpen(!isOpen)}
            className={
              "rounded bg-gray-400 p-2 text-white md:hidden " +
              (isOpen ? "border-2 border-gray-800" : "border border-gray-400")
            }
          >
            <svg
              className="h-6 w-6"
              fill="none"
              stroke="currentColor"
              viewBox="0 0 24 24"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth="2"
                d="M4 6h16M4 12h16m-7 6h7"
              ></path>
            </svg>
          </button>
        </div>
        {isOpen && (
          <div className="mt-4 flex flex-col space-y-2 md:hidden">
            <NavLink
              className="text-gray-700 hover:text-black"
              aria-current="page"
              to="/"
              onClick={() => setIsOpen(false)}
            >
              <i className="bi bi-house me-1"></i>
              Home
            </NavLink>
            <NavLink
              className="text-gray-700 hover:text-black"
              to="/login"
              onClick={() => setIsOpen(false)}
            >
              <i className="bi bi-box-arrow-in-right me-1"></i>
              Entrar
            </NavLink>
          </div>
        )}
      </div>
    </nav>
  );
};
export default NavBar;
