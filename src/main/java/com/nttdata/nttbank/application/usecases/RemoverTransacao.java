package com.nttdata.nttbank.application.usecases;

import com.nttdata.nttbank.application.gateways.RepositorioDeTransacao;

public class RemoverTransacao {

    private final RepositorioDeTransacao repositorio;

    public RemoverTransacao(RepositorioDeTransacao repositorio) {
        this.repositorio = repositorio;
    }

    public void removerTransacao(Long id) {
        repositorio.removerTransacao(id);
    }

}
