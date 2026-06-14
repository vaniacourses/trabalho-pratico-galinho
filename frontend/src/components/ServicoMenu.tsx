import { useState } from "react";
import { NavLink } from "react-router-dom";

export default function ServicosMenu() {
  const [aberto, setAberto] = useState(false);

  return (
    <div className="position-relative">
      <button
        className="btn btn-link text-decoration-none text-dark"
        onClick={() => setAberto(!aberto)}
      >
        Serviços {aberto ? "▲" : "▼"}
      </button>

      {aberto && (
        <div
          className="bg-white border rounded shadow-sm"
          style={{
            position: "absolute",
            top: "100%",
            left: 0,
            minWidth: "220px",
            zIndex: 1000,
          }}
        >
          <NavLink
            className="d-block px-3 py-2 text-decoration-none text-dark"
            to="/servicos"
          >
            <i className="bi bi-card-checklist me-1"></i>
            Serviços
          </NavLink>

          <NavLink
            className="d-block px-3 py-2 text-decoration-none text-dark"
            to="/servicosEmProcesso"
          >
            <i className="bi bi-card-list me-1"></i>
            Serviços Em Processo
          </NavLink>
        </div>
      )}
    </div>
  );
}