package com.nttdata.nttbank.application.usecases;

import com.nttdata.nttbank.application.gateways.RepositorioDeUsuario;

public class RemoverUsuario {

    private final RepositorioDeUsuario repositorio;

    public RemoverUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public void removerUsuario(Long id) {
        repositorio.removerUsuario(id);
    }
}
