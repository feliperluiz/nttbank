package com.nttdata.nttbank.application.usecases.usuario;

import com.nttdata.nttbank.application.gateways.RepositorioDeUsuario;
import com.nttdata.nttbank.domain.entities.Usuario;

public class AlterarUsuario {

    private final RepositorioDeUsuario repositorio;

    public AlterarUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario alterarUsuario(Usuario usuario) {
        return repositorio.alterarUsuario(usuario);
    }
}
