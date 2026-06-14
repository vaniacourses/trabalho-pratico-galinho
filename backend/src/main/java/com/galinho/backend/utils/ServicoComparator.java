package com.galinho.backend.utils;
import com.galinho.backend.model.Servicos.Servico;

import java.math.BigDecimal;
import java.util.Objects;

public class ServicoComparator {

    public static boolean houveMudanca(Servico antigo, Servico novo) {

        if (antigo == null || novo == null) {
            return true;
        }

        return !Objects.equals(antigo.getStatus(), novo.getStatus())
                || !Objects.equals(antigo.getDataInicio(), novo.getDataInicio())
                || !Objects.equals(antigo.getDataFim(), novo.getDataFim())
                || !Objects.equals(antigo.getDataPrevisao(), novo.getDataPrevisao())
                || !bigDecimalEquals(antigo.getOrcamento(), novo.getOrcamento())
                || !Objects.equals(antigo.getDescricao(), novo.getDescricao());
    }

    private static boolean bigDecimalEquals(BigDecimal a, BigDecimal b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.compareTo(b) == 0;
    }
}