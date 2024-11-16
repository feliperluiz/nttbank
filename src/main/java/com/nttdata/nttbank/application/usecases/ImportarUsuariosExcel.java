package com.nttdata.nttbank.application.usecases;

import com.nttdata.nttbank.application.gateways.RepositorioDeUsuario;
import com.nttdata.nttbank.domain.entities.Usuario;

import java.util.List;

public class ImportarUsuariosExcel {

    private final RepositorioDeUsuario repositorio;

    public ImportarUsuariosExcel(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public List<Usuario> importarUsuariosExcel() {
        return repositorio.importarUsuariosExcel();
    }
}
