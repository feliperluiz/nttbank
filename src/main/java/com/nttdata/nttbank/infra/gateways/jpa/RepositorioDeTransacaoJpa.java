package com.nttdata.nttbank.infra.gateways.jpa;

import com.nttdata.nttbank.application.gateways.RepositorioDeTransacao;
import com.nttdata.nttbank.domain.entities.Transacao;
import com.nttdata.nttbank.infra.gateways.mapper.TransacaoEntityMapper;
import com.nttdata.nttbank.infra.persistence.entities.TransacaoEntity;
import com.nttdata.nttbank.infra.persistence.repository.TransacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RepositorioDeTransacaoJpa implements RepositorioDeTransacao {

    @Autowired
    private TransacaoRepository repositorio;

    @Autowired
    private TransacaoEntityMapper mapper;

    @Override
    public Transacao criarTransacao(Transacao transacao) {
        TransacaoEntity entity = mapper.toEntity(transacao);
        repositorio.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Transacao> listarTransacoes() {
        return repositorio.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Transacao alterarTransacao(Transacao transacao) {
        Optional<TransacaoEntity> entity = repositorio.findById(transacao.getId());
        if (entity.isEmpty()) {
            throw new EntityNotFoundException("Entidade com ID " + transacao.getId() + " não encontrada.");
        }

        TransacaoEntity entityUpdated = mapper.toEntity(transacao);
        entityUpdated.setId(entity.get().getId());
        repositorio.save(entityUpdated);
        return mapper.toDomain(entityUpdated);
    }

    @Override
    public void removerTransacao(Long id) {
        Optional<TransacaoEntity> entity = repositorio.findById(id);
        if (entity.isPresent()) {
            repositorio.delete(entity.get());
        } else {
            throw new EntityNotFoundException("Entidade não encontrada.");
        }
    }
}