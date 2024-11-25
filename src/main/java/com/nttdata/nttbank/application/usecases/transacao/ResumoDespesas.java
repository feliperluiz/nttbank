package com.nttdata.nttbank.application.usecases.transacao;

import com.nttdata.nttbank.application.gateways.RepositorioDeTransacao;
import com.nttdata.nttbank.domain.entities.RelatorioTransacao;

import java.util.List;

public class ResumoDespesas {

    private final RepositorioDeTransacao repositorio;

    public ResumoDespesas(RepositorioDeTransacao repositorio) {
        this.repositorio = repositorio;
    }

    public List<RelatorioTransacao> listarTransacoes(String cpf) {
        return repositorio.resumoDespesas(cpf);
    }

}
