package com.nttdata.nttbank.infra.controller.dto;

import com.nttdata.nttbank.infra.persistence.enums.TipoConta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ContaDto(
        Long id,

        @NotNull
        Long usuarioId,

        @NotBlank
        String agencia,

        @NotBlank
        String conta,

        @NotBlank
        String dac,

        @NotNull
        BigDecimal saldo,

        @NotNull
        TipoConta tipoConta,

        @NotNull
        Boolean bloqueada){}