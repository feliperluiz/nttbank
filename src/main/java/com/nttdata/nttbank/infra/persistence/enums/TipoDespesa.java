package com.nttdata.nttbank.infra.persistence.enums;

import lombok.Getter;

@Getter
public enum TipoDespesa {

    ALIMENTACAO("Alimentação"),
    SAUDE("Saúde"),
    EDUCACAO("Educação"),
    LAZER("Lazer"),
    VESTUARIO("Vestuário"),
    CASA("Casa"),
    MORADIA("Moradia");

    private String tipo;

    TipoDespesa(String tipo) {
        this.tipo = tipo;
    }

}
