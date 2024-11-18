package com.nttdata.nttbank.infra.controller.dto;

import com.nttdata.nttbank.infra.persistence.enums.TipoConta;

import java.math.BigDecimal;

public record ContaDto(
        Long id, Long usuarioId, String agencia, String conta, String dac, BigDecimal saldo, TipoConta tipoConta, Boolean bloqueada){}