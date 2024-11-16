package com.nttdata.nttbank.application.usecases;

import com.nttdata.nttbank.application.gateways.RepositorioDeConta;
import com.nttdata.nttbank.domain.entities.Conta;

import java.util.List;

public class ListarContas {

    private final RepositorioDeConta repositorio;

    public ListarContas(RepositorioDeConta repositorio) {
        this.repositorio = repositorio;
    }

    public List<Conta> listarContas() {
        return repositorio.listarContas();
    }
}
