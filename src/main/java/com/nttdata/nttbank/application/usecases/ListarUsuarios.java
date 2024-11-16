package com.nttdata.nttbank.application.usecases;

import com.nttdata.nttbank.application.gateways.RepositorioDeUsuario;
import com.nttdata.nttbank.domain.entities.Usuario;
import java.util.List;

public class ListarUsuarios {

    private final RepositorioDeUsuario repositorio;

    public ListarUsuarios(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public List<Usuario> listarUsuarios() {
        return repositorio.listarUsuarios();
    }
}
