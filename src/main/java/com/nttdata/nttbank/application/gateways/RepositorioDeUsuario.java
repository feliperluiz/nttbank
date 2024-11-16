package com.nttdata.nttbank.application.gateways;

import com.nttdata.nttbank.domain.entities.Usuario;

import java.util.List;

public interface RepositorioDeUsuario {

    Usuario criarUsuario(Usuario usuario);

    List<Usuario> listarUsuarios();

    Usuario alterarUsuario(Usuario usuario);

    void removerUsuario(Long id);

    List<Usuario> importarUsuariosExcel();


}
