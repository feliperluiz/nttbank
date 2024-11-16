package com.nttdata.nttbank.application.usecases;

import com.nttdata.nttbank.application.gateways.RepositorioDeConta;

public class RemoverConta {

    private final RepositorioDeConta repositorio;

    public RemoverConta(RepositorioDeConta repositorio) {
        this.repositorio = repositorio;
    }

    public void removerConta(Long id) {
        repositorio.removerConta(id);
    }

}
