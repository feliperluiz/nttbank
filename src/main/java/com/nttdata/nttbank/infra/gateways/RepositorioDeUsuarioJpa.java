package com.nttdata.nttbank.infra.gateways;

import com.nttdata.nttbank.application.gateways.RepositorioDeUsuario;
import com.nttdata.nttbank.domain.entities.Usuario;

import java.util.List;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {
    @Override
    public Usuario criarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return null;
    }

    @Override
    public Usuario alterarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public void removerUsuario(Long id) {

    }

    @Override
    public List<Usuario> importarUsuariosExcel() {
        return null;
    }
}
