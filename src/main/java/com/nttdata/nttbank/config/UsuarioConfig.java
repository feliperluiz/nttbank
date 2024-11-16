package com.nttdata.nttbank.config;

import com.nttdata.nttbank.application.gateways.RepositorioDeUsuario;
import com.nttdata.nttbank.application.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    CriarUsuario criarUsuario(RepositorioDeUsuario repositorioDeUsuario){
        return new CriarUsuario(repositorioDeUsuario);
    }

    @Bean
    ListarUsuarios listarUsuarios(RepositorioDeUsuario repositorioDeUsuario){
        return new ListarUsuarios(repositorioDeUsuario);
    }

    @Bean
    AlterarUsuario alterarUsuario(RepositorioDeUsuario repositorioDeUsuario){
        return new AlterarUsuario(repositorioDeUsuario);
    }

    @Bean
    RemoverUsuario removerUsuario(RepositorioDeUsuario repositorioDeUsuario){
        return new RemoverUsuario(repositorioDeUsuario);
    }

    @Bean
    ImportarUsuariosExcel importarUsuariosExcel(RepositorioDeUsuario repositorioDeUsuario){
        return new ImportarUsuariosExcel(repositorioDeUsuario);
    }
}
