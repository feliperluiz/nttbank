package com.nttdata.nttbank.infra.persistence.enums;

import lombok.Getter;

@Getter
public enum TipoOperacao {

    DEBITO("Débito"),
    CREDITO("Crédito");

    private String operacao;

    TipoOperacao(String operacao) {
        this.operacao = operacao;
    }
}
