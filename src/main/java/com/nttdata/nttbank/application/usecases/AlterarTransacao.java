package com.nttdata.nttbank.application.usecases;

import com.nttdata.nttbank.application.gateways.RepositorioDeTransacao;
import com.nttdata.nttbank.domain.entities.Transacao;

public class AlterarTransacao {

    private final RepositorioDeTransacao repositorio;

    public AlterarTransacao(RepositorioDeTransacao repositorio) {
        this.repositorio = repositorio;
    }

    public Transacao alterarTransacao(Transacao transacao) {
        return repositorio.alterarTransacao(transacao);
    }

}
