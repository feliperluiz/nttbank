package com.nttdata.nttbank.infra.controller;

import com.nttdata.nttbank.infra.persistence.enums.TipoConta;

import java.math.BigDecimal;

public record ContaDto(
        Long usuarioId, String agencia, String conta, String dac, BigDecimal saldo, TipoConta tipoConta, Boolean bloqueada){}