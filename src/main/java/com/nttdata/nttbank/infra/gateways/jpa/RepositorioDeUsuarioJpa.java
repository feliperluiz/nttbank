package com.nttdata.nttbank.infra.gateways.jpa;

import com.nttdata.nttbank.application.gateways.RepositorioDeUsuario;
import com.nttdata.nttbank.domain.entities.Usuario;
import com.nttdata.nttbank.infra.gateways.mapper.UsuarioEntityMapper;
import com.nttdata.nttbank.infra.persistence.entities.UsuarioEntity;
import com.nttdata.nttbank.infra.persistence.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repositorio;

    private final UsuarioEntityMapper mapper;

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        repositorio.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return repositorio.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Usuario alterarUsuario(Usuario usuario) {
        UsuarioEntity entity = repositorio.findByCpf(usuario.getCpf());
        if (entity == null) {
            throw new EntityNotFoundException("Entidade com CPF " + usuario.getCpf() + " não encontrada.");
        }

        UsuarioEntity entityUpdated = mapper.toEntity(usuario);
        entityUpdated.setId(entity.getId());
        repositorio.save(entityUpdated);
        return mapper.toDomain(entityUpdated);
    }

    @Override
    public void removerUsuario(Long id) {
        Optional<UsuarioEntity> entity = repositorio.findById(id);
        if (entity.isPresent()) {
            repositorio.delete(entity.get());
        } else {
            throw new EntityNotFoundException("Entidade não encontrada.");
        }
    }

    @Override
    public List<Usuario> importarUsuariosExcel() {
        return null;
    }
}
