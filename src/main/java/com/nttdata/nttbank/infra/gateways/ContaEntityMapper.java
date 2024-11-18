package com.nttdata.nttbank.infra.gateways;

import com.nttdata.nttbank.domain.entities.Conta;
import com.nttdata.nttbank.infra.persistence.ContaEntity;

public class ContaEntityMapper {

    public ContaEntity toEntity(Conta conta){
        return new ContaEntity(conta.getId(), null, conta.getAgencia(), conta.getConta(), conta.getDac(), conta.getSaldo(), conta.getTipoConta(), conta.getBloqueada());
    }

    public Conta toDomain(ContaEntity entity){
        return new Conta(entity.getId(), entity.getUsuario().getId(), entity.getAgencia(), entity.getConta(), entity.getDac(), entity.getSaldo(), entity.getTipoConta(), entity.getBloqueada());
    }
}
