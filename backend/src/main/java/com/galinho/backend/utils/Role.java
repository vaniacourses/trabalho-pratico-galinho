package com.galinho.backend.utils;

public enum Role {
    CAIXA("caixa"),
    CLIENTE("cliente"),
    GERENTE("gerente"),
    GESTOR_ESTOQUE("gestor_estoque"),
    MECANICO("mecanico");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
