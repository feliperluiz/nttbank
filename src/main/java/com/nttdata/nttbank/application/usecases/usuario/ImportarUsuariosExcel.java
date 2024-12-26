package com.nttdata.nttbank.application.usecases.usuario;

import com.nttdata.nttbank.application.gateways.RepositorioDeUsuario;
import com.nttdata.nttbank.domain.entities.Usuario;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public class ImportarUsuariosExcel {

    private final RepositorioDeUsuario repositorio;

    public ImportarUsuariosExcel(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public List<Usuario> importarUsuariosExcel(MultipartFile file) throws IOException {
        return repositorio.importarUsuariosExcel(file);
    }
}
