package com.nttdata.nttbank.infra.gateways.jpa;

import com.nttdata.nttbank.application.gateways.RepositorioDeTransacao;
import com.nttdata.nttbank.domain.entities.RelatorioTransacao;
import com.nttdata.nttbank.domain.entities.Transacao;
import com.nttdata.nttbank.infra.gateways.mapper.TransacaoEntityMapper;
import com.nttdata.nttbank.infra.persistence.entities.ContaEntity;
import com.nttdata.nttbank.infra.persistence.entities.TransacaoEntity;
import com.nttdata.nttbank.infra.persistence.repository.ContaRepository;
import com.nttdata.nttbank.infra.persistence.repository.TransacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RepositorioDeTransacaoJpa implements RepositorioDeTransacao {

    private final TransacaoRepository repositorio;

    private final ContaRepository contaRepository;

    private final TransacaoEntityMapper mapper;

    @Override
    public Transacao criarTransacao(Transacao transacao) {
        ContaEntity contaEntity = contaRepository.findById(transacao.getContaId())
                .orElseThrow(() -> new EntityNotFoundException("Conta não encontrada"));

        TransacaoEntity entity = mapper.toEntity(transacao);
        entity.setConta(contaEntity);

        if (transacao.getContaIdTransferencia() != null) {
            Optional<ContaEntity> contaTransf = contaRepository.findById(transacao.getContaIdTransferencia());
            entity.setContaTransferencia(contaTransf.get());
        }

        entity = repositorio.save(entity);
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
        TransacaoEntity entity = repositorio.findById(transacao.getId())
                .orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));

        TransacaoEntity entityUpdated = mapper.toEntity(transacao);
        entityUpdated.setId(entity.getId());
        entityUpdated.setContaTransferencia(entity.getContaTransferencia());
        entityUpdated.setConta(entity.getConta());
        entityUpdated = repositorio.save(entityUpdated);
        return mapper.toDomain(entityUpdated);
    }

    @Override
    public void removerTransacao(Long id) {
        TransacaoEntity entity = repositorio.findById(id).orElseThrow(() -> new EntityNotFoundException("Transação não encontrada."));
        repositorio.delete(entity);
    }

    @Override
    public List<RelatorioTransacao> resumoDespesas(String cpf) {
        return repositorio.findTransacoesPorCpf(cpf);
    }


}