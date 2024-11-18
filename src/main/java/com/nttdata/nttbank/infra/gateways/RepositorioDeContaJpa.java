package com.nttdata.nttbank.infra.gateways;

import com.nttdata.nttbank.application.gateways.RepositorioDeConta;
import com.nttdata.nttbank.domain.entities.Conta;
import com.nttdata.nttbank.infra.persistence.ContaEntity;
import com.nttdata.nttbank.infra.persistence.ContaRepository;
import com.nttdata.nttbank.infra.persistence.TransacaoEntity;
import com.nttdata.nttbank.infra.persistence.UsuarioEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RepositorioDeContaJpa implements RepositorioDeConta {

    @Autowired
    private ContaRepository repositorio;

    @Autowired
    private ContaEntityMapper mapper;

    @Override
    public Conta criarConta(Conta conta) {
        ContaEntity entity = mapper.toEntity(conta);
        repositorio.save(entity);
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
        repositorio.save(entityUpdated);
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