package com.nttdata.nttbank.application.usecases.usuario;

import com.nttdata.nttbank.application.gateways.RepositorioDeUsuario;
import com.nttdata.nttbank.domain.entities.Usuario;

public class CriarUsuario {

    private final RepositorioDeUsuario repositorio;

    public CriarUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario criarUsuario(Usuario usuario) {
        return repositorio.criarUsuario(usuario);
    }
}
