package com.nttdata.nttbank.config;

import com.nttdata.nttbank.application.gateways.RepositorioDeUsuario;
import com.nttdata.nttbank.application.usecases.usuario.*;
import com.nttdata.nttbank.infra.gateways.jpa.RepositorioDeUsuarioJpa;
import com.nttdata.nttbank.infra.gateways.mapper.UsuarioEntityMapper;
import com.nttdata.nttbank.infra.persistence.repository.UsuarioRepository;
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

    @Bean
    RepositorioDeUsuarioJpa criarRepositorioUsuario(UsuarioRepository repositorio, UsuarioEntityMapper mapper){
        return new RepositorioDeUsuarioJpa(repositorio, mapper);
    }

    @Bean
    UsuarioEntityMapper retornaMapperUsuario(){
        return new UsuarioEntityMapper();
    }
}
