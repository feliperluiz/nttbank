package com.nttdata.nttbank.infra.controller;

import com.nttdata.nttbank.infra.persistence.enums.TipoDespesa;
import com.nttdata.nttbank.infra.persistence.enums.TipoOperacao;

import java.math.BigDecimal;

public record TransacaoDto(Long id,
    Long contaId,
    BigDecimal valor,
    String descricao,
    TipoOperacao tipoOperacao,
    Long contaIdTransferencia,
    TipoDespesa tipoDespesa){}