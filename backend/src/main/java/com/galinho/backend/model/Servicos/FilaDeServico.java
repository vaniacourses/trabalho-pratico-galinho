package com.galinho.backend.model.Servicos;

import java.util.LinkedList;
import java.util.Queue;

//Nao faz mtt sentido existir, deixamos em lógica e não implementamos?

public class FilaDeServico {
    private static FilaDeServico fila = null;
    private Queue<Servico> servicos;

    private FilaDeServico(){
        servicos = new LinkedList<Servico>();
    }

    public static FilaDeServico pegarFila(){
        if(fila == null){
            fila = new FilaDeServico();
            //Encher a fila com os serviços do banco de estaodo = TipoStatus.A_SER_INICIADO
        }
        return fila;
    }

    public void adicionar(Servico servico){
        servicos.add(servico);
    }

    public Servico pegarProximo(){
        return servicos.poll();
    }

    public Servico verProximo(){
        return servicos.peek();
    }

    public boolean vazio(){
        return servicos.isEmpty();
    }

}
