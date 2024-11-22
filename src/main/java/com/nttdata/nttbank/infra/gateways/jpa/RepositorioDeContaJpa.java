package com.nttdata.nttbank.infra.gateways.jpa;

import com.nttdata.nttbank.application.gateways.RepositorioDeConta;
import com.nttdata.nttbank.domain.entities.Conta;
import com.nttdata.nttbank.infra.gateways.mapper.ContaEntityMapper;
import com.nttdata.nttbank.infra.persistence.entities.ContaEntity;
import com.nttdata.nttbank.infra.persistence.entities.UsuarioEntity;
import com.nttdata.nttbank.infra.persistence.repository.ContaRepository;
import com.nttdata.nttbank.infra.persistence.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RepositorioDeContaJpa implements RepositorioDeConta {

    private final ContaRepository repositorio;

    private final UsuarioRepository usuarioRepository;

    private final ContaEntityMapper mapper;

    @Override
    public Conta criarConta(Conta conta) {
        ContaEntity entity = mapper.toEntity(conta);

        UsuarioEntity usuarioEntity = usuarioRepository.findById(conta.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        entity.setUsuario(usuarioEntity);
        entity = repositorio.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Conta> listarContas() {
        return repositorio.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Conta alterarConta(Conta conta) {
        Optional<ContaEntity> entity = repositorio.findById(conta.getId());
        if (entity.isEmpty()) {
            throw new EntityNotFoundException("Entidade com ID " + conta.getId() + " não encontrada.");
        }
        ContaEntity entityUpdated = mapper.toEntity(conta);
        entityUpdated.setId(entity.get().getId());
        entityUpdated = repositorio.save(entityUpdated);
        return mapper.toDomain(entityUpdated);
    }

    @Override
    public void removerConta(Long id) {
        Optional<ContaEntity> entity = repositorio.findById(id);
        if (entity.isPresent()) {
            repositorio.delete(entity.get());
        } else {
            throw new EntityNotFoundException("Entidade não encontrada.");
        }
    }
}