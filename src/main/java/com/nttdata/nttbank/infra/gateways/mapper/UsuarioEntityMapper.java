package com.nttdata.nttbank.infra.gateways.mapper;

import com.nttdata.nttbank.domain.entities.Usuario;
import com.nttdata.nttbank.infra.persistence.entities.UsuarioEntity;

public class UsuarioEntityMapper {

    public UsuarioEntity toEntity(Usuario usuario){
        return new UsuarioEntity(usuario.getId(), usuario.getCpf(), usuario.getNome(),
                usuario.getLogin(), usuario.getSenha(), usuario.getNascimento(), usuario.getEmail());
    }

    public Usuario toDomain(UsuarioEntity entity){
        return new Usuario(entity.getId(), entity.getCpf(), entity.getNome(), entity.getLogin(), entity.getSenha(),
                entity.getNascimento(), entity.getEmail());
    }
}
