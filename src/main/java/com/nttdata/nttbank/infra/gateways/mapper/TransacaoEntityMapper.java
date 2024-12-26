package com.nttdata.nttbank.infra.gateways.mapper;

import com.nttdata.nttbank.domain.entities.Transacao;
import com.nttdata.nttbank.infra.persistence.entities.TransacaoEntity;

public class TransacaoEntityMapper {

    public TransacaoEntity toEntity(Transacao transacao){
        return new TransacaoEntity(transacao.getId(), null, transacao.getValor(), transacao.getDescricao(), transacao.getTipoOperacao(), null, transacao.getTipoDespesa());
    }

    public Transacao toDomain(TransacaoEntity entity){
        Long idContaTransferencia = entity.getContaTransferencia() != null ? entity.getContaTransferencia().getId() : null;
        return new Transacao(entity.getId(), entity.getConta().getId(), entity.getValor(), entity.getDescricao(), entity.getTipoOperacao(), idContaTransferencia, entity.getTipoDespesa());
    }
}
