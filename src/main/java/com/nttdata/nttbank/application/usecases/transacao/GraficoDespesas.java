package com.nttdata.nttbank.application.usecases.transacao;

import com.nttdata.nttbank.application.gateways.RepositorioDeTransacao;

public class GraficoDespesas {

    public GraficoDespesas(RepositorioDeTransacao repositorio) {
        this.repositorio = repositorio;
    }

    private final RepositorioDeTransacao repositorio;

    public void graficoDespesas(String cpf) {
        repositorio.graficoDespesas(cpf);
    }


}
