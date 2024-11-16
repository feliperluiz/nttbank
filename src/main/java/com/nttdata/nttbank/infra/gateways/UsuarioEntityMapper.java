package com.nttdata.nttbank.infra.gateways;

import com.nttdata.nttbank.domain.entities.Usuario;
import com.nttdata.nttbank.infra.persistence.UsuarioEntity;

public class UsuarioEntityMapper {

    public UsuarioEntity toEntity(Usuario usuario){
        return new UsuarioEntity(null, usuario.getCpf(), usuario.getNome(),
                usuario.getLogin(), usuario.getNascimento(), usuario.getEmail());
    }

    public Usuario toDomain(UsuarioEntity entity){
        return new Usuario(entity.getCpf(), entity.getNome(), entity.getLogin(),
                entity.getNascimento(), entity.getEmail());
    }
}
