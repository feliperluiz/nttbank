package com.nttdata.nttbank.infra.controller.dto;

import com.nttdata.nttbank.infra.persistence.enums.TipoDespesa;
import com.nttdata.nttbank.infra.persistence.enums.TipoOperacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransacaoDto(
        Long id,

        @NotNull
        Long contaId,

        @NotNull
        BigDecimal valor,

        @NotBlank
        String descricao,

        @NotNull
        TipoOperacao tipoOperacao,

        Long contaIdTransferencia,
        @NotNull
        TipoDespesa tipoDespesa){}