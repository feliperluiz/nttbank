package com.nttdata.nttbank.application.usecases;

import com.nttdata.nttbank.application.gateways.RepositorioDeTransacao;
import com.nttdata.nttbank.domain.entities.Transacao;

public class CriarTransacao {

    private final RepositorioDeTransacao repositorio;

    public CriarTransacao(RepositorioDeTransacao repositorio) {
        this.repositorio = repositorio;
    }

    public Transacao criarTransacao(Transacao transacao) {
        return repositorio.criarTransacao(transacao);
    }
}
