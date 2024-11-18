package com.nttdata.nttbank.application.usecases.transacao;

import com.nttdata.nttbank.application.gateways.RepositorioDeTransacao;
import com.nttdata.nttbank.domain.entities.Transacao;

import java.util.List;

public class ListarTransacoes {

    private final RepositorioDeTransacao repositorio;

    public ListarTransacoes(RepositorioDeTransacao repositorio) {
        this.repositorio = repositorio;
    }

    public List<Transacao> listarTransacoes() {
        return repositorio.listarTransacoes();
    }


}
