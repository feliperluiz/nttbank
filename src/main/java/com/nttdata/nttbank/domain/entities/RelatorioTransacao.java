package com.nttdata.nttbank.domain.entities;

import com.nttdata.nttbank.infra.persistence.enums.TipoDespesa;
import com.nttdata.nttbank.infra.persistence.enums.TipoOperacao;

import java.math.BigDecimal;

public record RelatorioTransacao (
        String nome,
        Long contaId,
        BigDecimal valor,
        String descricao,
        TipoDespesa tipoDespesa,
        TipoOperacao tipoOperacao
) {
}
