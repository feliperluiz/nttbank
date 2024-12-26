package com.nttdata.nttbank.application.usecases.transacao;

import com.nttdata.nttbank.application.gateways.RepositorioDeTransacao;

public class ResumoPdf {

    public ResumoPdf(RepositorioDeTransacao repositorio) {
        this.repositorio = repositorio;
    }

    private final RepositorioDeTransacao repositorio;

    public byte[] resumoPdf() {
        return repositorio.resumoPdf();
    }

}
