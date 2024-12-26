package com.nttdata.nttbank.application.gateways;

import com.nttdata.nttbank.domain.entities.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface RepositorioDeUsuario {

    Usuario criarUsuario(Usuario usuario);

    List<Usuario> listarUsuarios();

    Usuario alterarUsuario(Usuario usuario);

    void removerUsuario(Long id);

    List<Usuario> importarUsuariosExcel(MultipartFile file) throws IOException;

}
